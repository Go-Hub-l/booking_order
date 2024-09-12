package com.xlb.controller.data;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.xlb.conststr.NET;
import com.xlb.conststr.Time;
import com.xlb.dao.StationInfoDao;
import com.xlb.dao.StationStopInfoDao;
import com.xlb.dao.TicketInfoDao;
import com.xlb.entity.*;
import com.xlb.util.GetNetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/station/list")
public class GainStationListController {
    @Autowired
    private StationInfoDao stationInfoDao;

    @Autowired
    private TicketInfoDao ticketInfoDao;

    @Autowired
    private StationStopInfoUtil stationStopInfoUtil;

    /**
     * 批量插入100条，后续可以改成配置
     */
    private final Integer INSERT_COUNT = 100;

    @GetMapping("/insert")
    public String select(String departDate, String departStation, String arriveStation) {
        //查询获得三字码
        StationInfo departStationInfo = stationInfoDao.queryByStationName(departStation);
        StationInfo arriveStationInfo = stationInfoDao.queryByStationName(arriveStation);

        Assert.isTrue(departStationInfo != null, "departStationInfo is null");
        Assert.isTrue(arriveStationInfo != null, "arriveStationInfo is null");
        Assert.isTrue(StrUtil.isNotEmpty(departStationInfo.getStationCode()), "departStationInfo code is null");
        Assert.isTrue(StrUtil.isNotEmpty(arriveStationInfo.getStationCode()), "arriveStationInfo code is null");
        Assert.isTrue(departDate != null && departDate.split("-").length == 3, "departDate is null or format error");

        //拼接URL
        String stationListUrl = NET.STATION_LIST.replace("#{train_date}", departDate).replace("#{from_station}", departStationInfo.getStationCode()).replace("#{to_station}", arriveStationInfo.getStationCode());
        //发起网络请求
        String stationListStr = GetNetUtil.get(stationListUrl, "UTF-8");
        Assert.isTrue(StrUtil.isNotEmpty(stationListStr), "stationListStr is null or empty");

        //解析数据
        JSONObject stationListJson = null;
        try {
            stationListJson = JSONUtil.parseObj(stationListStr);

            StationList12306 stationList = JSONUtil.toBean(stationListJson, StationList12306.class);

            Assert.isTrue(stationList != null, "stationList is null");
            Assert.isTrue(stationList.getData() != null, "stationList data is null");
            Assert.isTrue(CollUtil.isNotEmpty(stationList.getData().getResult()), "stationList result is null or empty");

            //解析数据
            List<String> resultList = stationList.getData().getResult();
            List<TicketInfo> ticketInfoList = CollUtil.newArrayList();

            resultList.forEach(ticketInfo -> {
                String[] split = ticketInfo.split("\\|");
                Assert.isTrue(split.length == 56, "ticketInfo format error");

                TicketInfo ticketInfoObj = new TicketInfo();
                ticketInfoObj.setTrainNumberCode(split[2]);
                ticketInfoObj.setTrainNumber(split[3]);
                ticketInfoObj.setStartStationCode(split[4]);
                ticketInfoObj.setEndStationCode(split[5]);
                ticketInfoObj.setDepartStationCode(split[6]);
                ticketInfoObj.setArriveStationCode(split[7]);
                ticketInfoObj.setDepartTime(split[8]);
                ticketInfoObj.setArriveTime(split[9]);
                ticketInfoObj.setSpendTime(split[10]);
                ticketInfoObj.setSoftSeatLeft(getTicketLeft(split[23]));
                ticketInfoObj.setNoSeatLeft(getTicketLeft(split[26]));
                ticketInfoObj.setHardBedLeft(getTicketLeft(split[28]));
                ticketInfoObj.setHardSeatLeft(getTicketLeft(split[29]));
                ticketInfoObj.setSecondSeatLeft(getTicketLeft(split[30]));
                ticketInfoObj.setFirstSeatLeft(getTicketLeft(split[31]));
                ticketInfoObj.setBusinessSeatLeft(getTicketLeft(split[32]));

                ticketInfoObj.setCreateTime(new Date());
                ticketInfoObj.setDatachangeTime(new Date());

                //先查表，如果有则直接返回：后续修改为有则更新，没有则插入
                List<TicketInfo> infos = ticketInfoDao.queryByTrainNumber(ticketInfoObj.getTrainNumber());
                if (CollUtil.isEmpty(infos)
                        || (infos.stream().noneMatch(info -> info.getTrainNumber().equals(ticketInfoObj.getTrainNumber())
                        && info.getDepartStationCode().equals(ticketInfoObj.getDepartStationCode())
                        && info.getArriveStationCode().equals(ticketInfoObj.getArriveStationCode())))) {
                    ticketInfoList.add(ticketInfoObj);
                }

                //达到批量插入的条数，就批量插入
                if (ticketInfoList.size() == INSERT_COUNT) {
                    ticketInfoDao.insertBatch(ticketInfoList);
                    //清空集合
                    ticketInfoList.clear();
                }
            });

            //插入剩余的条数
            if (CollUtil.isNotEmpty(ticketInfoList)) {
                ticketInfoDao.insertBatch(ticketInfoList);
                ticketInfoList.clear();
            }

            Thread.sleep(Time.MINUTE);
        } catch (Exception e) {
            log.error("parse stationListJson error", e);
            return "parse stationListJson error";
        }

        return "insert success";
    }

    private static int getTicketLeft(String ticketLeft) {
        if (StrUtil.isEmpty(ticketLeft) || ticketLeft.contains("无")) return 0;
        if(ticketLeft.contains("有")) return 99;
        if(ticketLeft.contains("*")) return 0;

        int left = 0;
        try {
            left = Integer.parseInt(ticketLeft);
        } catch (NumberFormatException e) {
            left = 0;
            log.error("ticketLeft format error:{}",ticketLeft, e);
        }
        return left;
    }
}
