package com.xlb.controller.data;

import com.xlb.conststr.NET;
import com.xlb.entity.StationInfo;
import com.xlb.service.StationInfoService;
import com.xlb.util.GetNetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

@RestController
@Slf4j
@RequestMapping("/stationinfo")
public class GainStationInfoController {
    @Autowired
    private StationInfoService stationInfoService;

    @GetMapping("/insert")
    public String flushStationInfo() {
        // 目标网站的URL
        String url = NET.STATION_INFO;
        String charset = "UTF-8";

        // 得到JSON字符串
        String jsonResult = GetNetUtil.get(url, charset);
        if (!jsonResult.isEmpty()) {
            //取出单引号内的车站信息
            String[] split1 = jsonResult.split("\'");
            if (split1.length > 1) {
                jsonResult = split1[1];
            }
            // 切分车站信息，然后存在数据库中
            String[] stationInfos = jsonResult.split("\\|\\|\\|");
            if (stationInfos.length > 1) {
                int[] count = {0};
                Arrays.stream(stationInfos).forEach(stationInfo -> {
                    // 切分具体的车站信息
                    String[] stationInfoArr = stationInfo.split("\\|");
                    if (stationInfoArr.length == 8) {
                        StationInfo entity = new StationInfo();
                        entity.setStationName(stationInfoArr[1]);
                        entity.setStationCode(stationInfoArr[2]);
                        entity.setStationSpell(stationInfoArr[3]);
                        entity.setStationSzm(stationInfoArr[4]);
                        entity.setStationCount(Integer.parseInt(stationInfoArr[5]));
                        entity.setCityId(stationInfoArr[6]);
                        entity.setCityName(stationInfoArr[7]);
                        entity.setCreateTime(new Timestamp(new Date().getTime()));

                        stationInfoService.insert(entity);
                    }
                });
            }
        }

        return "flush station info success";
    }

    @GetMapping("/update")
    public String updateStationInfo() {
        // 目标网站的URL
        String url = NET.STATION_INFO;
        String charset = "UTF-8";

        // 得到JSON字符串
        String jsonResult = GetNetUtil.get(url, charset);
        if (!jsonResult.isEmpty()) {
            //取出单引号内的车站信息
            String[] split1 = jsonResult.split("\'");
            if (split1.length > 1) {
                jsonResult = split1[1];
            }
            // 切分车站信息，然后存在数据库中
            String[] stationInfos = jsonResult.split("\\|\\|\\|");
            if (stationInfos.length > 1) {
                int[] count = {0};
                Arrays.stream(stationInfos).forEach(stationInfo -> {
                    // 切分具体的车站信息
                    String[] stationInfoArr = stationInfo.split("\\|");
                    if (stationInfoArr.length == 8) {
                        StationInfo entity = new StationInfo();
                        entity.setStationName(stationInfoArr[1]);
                        entity.setStationCode(stationInfoArr[2]);
                        entity.setStationSpell(stationInfoArr[3]);
                        entity.setStationSzm(stationInfoArr[4]);
                        entity.setStationCount(Integer.parseInt(stationInfoArr[5]));
                        entity.setCityId(stationInfoArr[6]);
                        entity.setCityName(stationInfoArr[7]);
                        entity.setDatachangeTime(new Timestamp(new Date().getTime()));

                        stationInfoService.update(entity);
                    }
                });
                log.info("total count:" + count[0]);
            }
        }

        return "update station info success";
    }
}
