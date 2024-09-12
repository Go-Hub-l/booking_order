package com.xlb.entity;

import lombok.Data;

import java.util.List;

@Data
public class StationStopInfo12306 {
    private String validateMessagesShowId;
    private Boolean status;
    private Integer httpstatus;
    private StationInfoList data;

    @Data
    public static class StationInfoList {
        private List<StationInfo> data;

        @Data
        public static class StationInfo{
            /**
             * 站名：亳州南
             */
            private String station_name;
            private String train_class_name;
            private String isChina;
            private String service_type;
            /**
             * 终点站:上海虹桥
             */
            private String end_station_name;
            /**
             * 停站时间：格式：HH:mm
             */
            private String stopover_time;
            private String country_code;
            private Boolean isEnabled;
            private String country_name;
            /**
             * 到达时间：格式：HH:mm
             */
            private String arrive_time;
            /**
             * 始发站：亳州南
             */
            private String start_station_name;
            /**
             * 车次号
             */
            private String station_train_code;
            /**
             * 出发时间：格式：HH:mm
             */
            private String start_time;
            /**
             * 到达时间：格式：HH:mm
             */
            private String end_time;
            /**
             * 站点序号
             */
            private String station_no;
        }
    }
}
