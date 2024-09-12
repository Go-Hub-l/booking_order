package com.xlb.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (StationInfo)实体类
 *
 * @author makejava
 * @since 2024-09-10 21:48:47
 */
@Data
public class StationInfo {
    private Integer tid;
    /**
     * 车站名
     */
    private String stationName;
    /**
     * 车站三字码
     */
    private String stationCode;
    /**
     * 车站名拼音
     */
    private String stationSpell;
    /**
     * 车站首字母
     */
    private String stationSzm;
    /**
     * 车站数
     */
    private Integer stationCount;
    /**
     * 城市id
     */
    private String cityId;
    
    private String cityName;
    
    private Date createTime;
    
    private Date datachangeTime;

}

