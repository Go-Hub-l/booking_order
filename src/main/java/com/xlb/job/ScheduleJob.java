package com.xlb.job;


import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import com.xlb.controller.data.StationStopInfoUtil;
import com.xlb.dao.TicketInfoDao;
import com.xlb.entity.TicketInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Slf4j
@Component
public class ScheduleJob {
    // 后续改成配置
    private static final Integer DELAY_MINUTES = 10 * 60 *1000; //分钟

    @Autowired
    private TicketInfoDao ticketInfoDao;

    @Autowired
    private StationStopInfoUtil stationStopInfoUtil;


    @Scheduled(fixedDelay = 10 * 1000)
    public void runEveryFixedDelay() {
        log.info("runEveryFixedDelay begin execute: {}", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

        //ticket_info表里读车次信息
        List<TicketInfo> ticketInfos = ticketInfoDao.queryAll();
        if (CollUtil.isEmpty(ticketInfos)) {
            log.info("ticketInfos is empty");
            return;
        }

        //遍历车次，添加经停站信息
        log.info("runEveryFixedDelay ticketInfos size:{}", ticketInfos.size());
        int count = stationStopInfoUtil.insertStationStop(ticketInfos, DateUtil.format(new Date(), "yyyy-MM-dd"));
        log.info("runEveryFixedDelay insertStationStop total:{}, ticketInfos size:{}", count, ticketInfos.size());
        log.info("runEveryFixedDelay execute success!");
    }
}
