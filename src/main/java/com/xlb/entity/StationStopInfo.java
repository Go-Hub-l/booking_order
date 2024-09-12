package com.xlb.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (StationStopInfo)实体类
 *
 * @author makejava
 * @since 2024-09-11 10:50:08
 */
@Data
public class StationStopInfo {
    /**
     * 主键
     */
    private Integer tid;
    /**
     * 车站名
     */
    private String stationName;
    /**
     * 火车类型：高速
     */
    private String trainClassName;
    /**
     * 出发站名
     */
    private String startStationName;
    /**
     * 到达站名
     */
    private String endStationName;
    /**
     * 车次号
     */
    private String stationTrainCode;
    /**
     * 是否启用
     */
    private Integer isEnabled;
    /**
     * 出发时间HH:mm
     */
    private String startTime;
    /**
     * 到达时间HH:mm
     */
    private String arriveTime;
    /**
     * 车站顺序
     */
    private Integer stationNo;
    /**
     * 经停时间：2分钟
     */
    private String stopoverTime;
    
    private Date createTime;
    
    private Date datachangeTime;
}

