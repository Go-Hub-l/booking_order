package com.xlb.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class StationList12306 {
    private Integer httpstatus;
    private Data data;
    private String message;
    private Boolean status;

    @lombok.Data
    public static class Data {
        private List<String> result;
        private String flag;
        private String level;
        private String sametlc;
        Map<String, String> map;
    }
}
