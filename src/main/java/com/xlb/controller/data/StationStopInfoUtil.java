package com.xlb.controller.data;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.xlb.conststr.NET;
import com.xlb.dao.StationStopInfoDao;
import com.xlb.entity.StationStopInfo;
import com.xlb.entity.StationStopInfo12306;
import com.xlb.entity.TicketInfo;
import com.xlb.util.GetNetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.*;

@Slf4j
@Component
public class StationStopInfoUtil {
    @Autowired
    private StationStopInfoDao stationStopInfoDao;

    /**
     * 批量插入100条，后续可以改成配置
     */
    private final Integer INSERT_COUNT = 100;

    /**
     * 批量插入
     * @param ticketInfoList
     * @param departDate
     */
    public int insertStationStop(List<TicketInfo> ticketInfoList, String departDate) {
        int count = 0;
        int index = 0;
        for (TicketInfo ticketInfo : ticketInfoList) {
            log.info("insert stationStop index: {}, trainNumber:{}", index++, ticketInfo.getTrainNumber());
            count += insertStationStop(ticketInfo, departDate);
        }

        log.info("insert stationStop total:{}, tickeInfoList size:{}", count, ticketInfoList.size());

        return count;
    }

    /**
     * 需要加锁：list和job同时操作时，可能会出现重复数据（后续job时再加，暂时先不加）
     * @param ticketInfo
     * @param departDate
     * @return
     */
    public int insertStationStop(TicketInfo ticketInfo, String departDate) {
        int[] count = {0};
        String stationStopUrl = "";
        try {
            // 先从表中查询是否有该车次，如果有则直接返回
            List<StationStopInfo> infos = stationStopInfoDao.queryByTrainNumber(ticketInfo.getTrainNumber());
            if (CollUtil.isNotEmpty(infos)) {
                log.info("this trainNumber:{} has been inserted, skip it!", ticketInfo.getTrainNumber());
                return 0;
            }

            stationStopUrl = NET.STATION_STOP
                    .replace("#{train_no}", ticketInfo.getTrainNumberCode())
                    .replace("#{from_station_code}", ticketInfo.getStartStationCode())
                    .replace("#{to_station_code}", ticketInfo.getEndStationCode())
                    .replace("#{depart_date}", departDate);
            try {
                //随机休眠diff秒，防止请求过快
                Random random = new Random();
                int diff = random.nextInt(10) + 5;
                log.info("random sleep {} seconds", diff);
                Thread.sleep(diff * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String stationStopStr = GetNetUtil.get(stationStopUrl, "UTF-8");

            Assert.isTrue(StrUtil.isNotEmpty(stationStopStr), "stationStopStr is null or empty");

            JSONObject jsonObject = JSONUtil.parseObj(stationStopStr);
            StationStopInfo12306 stationStopInfo12306 = jsonObject.toBean(StationStopInfo12306.class);
            Assert.isTrue(stationStopInfo12306 != null, "stationStopInfo12306 is null");
            Assert.isTrue(stationStopInfo12306.getData() != null, "stationStopInfo12306 data is null");

            if (CollUtil.isEmpty(stationStopInfo12306.getData().getData())) {
                log.info("this trainNumber:{}, this date: {}, no data, skip it!", ticketInfo.getTrainNumber(), departDate);
                return 0;
            }

            List<StationStopInfo12306.StationInfoList.StationInfo> data = stationStopInfo12306.getData().getData();
            StationStopInfo12306.StationInfoList.StationInfo firstStationInfo = data.get(0);
            List<StationStopInfo> stationStopInfoList = CollUtil.newArrayList();

            if (!firstStationInfo.getStation_train_code().equals(ticketInfo.getTrainNumber())) {
                log.info("this trainNumber changed , skip it! origin:{} new:{}", ticketInfo.getTrainNumber(), firstStationInfo.getStation_train_code());
                return 0;
            }

            data.forEach(stationInfo -> {
                StationStopInfo stationStopInfo = new StationStopInfo();
                stationStopInfo.setStationName(stationInfo.getStation_name());
                //这些数据只有第一个元素有
                stationStopInfo.setTrainClassName(firstStationInfo.getTrain_class_name());
                stationStopInfo.setStartStationName(firstStationInfo.getStart_station_name());
                stationStopInfo.setEndStationName(firstStationInfo.getEnd_station_name());
                stationStopInfo.setStationTrainCode(firstStationInfo.getStation_train_code());
                stationStopInfo.setIsEnabled(stationInfo.getIsEnabled() ? 1 : 0);
                stationStopInfo.setStartTime(stationInfo.getStart_time());
                stationStopInfo.setArriveTime(stationInfo.getArrive_time());
                stationStopInfo.setStationNo(Integer.parseInt(stationInfo.getStation_no()));
                stationStopInfo.setStopoverTime(stationInfo.getStopover_time());

                stationStopInfo.setCreateTime(new Date());
                stationStopInfo.setDatachangeTime(new Date());

                stationStopInfoList.add(stationStopInfo);

                if(stationStopInfoList.size() == INSERT_COUNT) {
                    count[0] += stationStopInfoDao.insertBatch(stationStopInfoList);
                    stationStopInfoList.clear();
                }
            });

            if(CollUtil.isNotEmpty(stationStopInfoList)) {
                count[0] += stationStopInfoDao.insertBatch(stationStopInfoList);
                stationStopInfoList.clear();
            }
        } catch (RuntimeException e) {
            log.error("insertStationStop error, trainNumber:{}, url:{}", ticketInfo.getTrainNumber(), stationStopUrl, e);
        }

        log.info("insert {} stationStop success:{}", ticketInfo.getTrainNumber(), count[0]);
        return count[0];
    }
}
