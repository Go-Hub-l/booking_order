package com.xlb.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TicketInfo)实体类
 *
 * @author makejava
 * @since 2024-09-10 21:40:12
 */
public class TicketInfo {
    /**
     * 主键
     */
    private Integer tid;
    /**
     * 车次代号
     */
    private String trainNumberCode;
    /**
     * 车次
     */
    private String trainNumber;
    /**
     * 始发站代号
     */
    private String startStationCode;
    /**
     * 终达站代号
     */
    private String endStationCode;
    /**
     * 出发站代号
     */
    private String departStationCode;
    /**
     * 到达站代号
     */
    private String arriveStationCode;
    /**
     * 出发时间 HH:mm
     */
    private String departTime;
    /**
     * 到达时间 HH:mm
     */
    private String arriveTime;
    /**
     * 耗时 HH:mm
     */
    private String spendTime;
    /**
     * 软卧余票数
     */
    private Integer softSeatLeft;
    /**
     * 无座余票数
     */
    private Integer noSeatLeft;
    /**
     * 硬卧余票数
     */
    private Integer hardBedLeft;
    /**
     * 硬座余票数
     */
    private Integer hardSeatLeft;
    /**
     * 二等座余票数
     */
    private Integer secondSeatLeft;
    /**
     * 一等座余票数
     */
    private Integer firstSeatLeft;
    /**
     * 商务/特等座余票数
     */
    private Integer businessSeatLeft;
    
    private Date createTime;
    
    private Date datachangeTime;


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTrainNumberCode() {
        return trainNumberCode;
    }

    public void setTrainNumberCode(String trainNumberCode) {
        this.trainNumberCode = trainNumberCode;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getStartStationCode() {
        return startStationCode;
    }

    public void setStartStationCode(String startStationCode) {
        this.startStationCode = startStationCode;
    }

    public String getEndStationCode() {
        return endStationCode;
    }

    public void setEndStationCode(String endStationCode) {
        this.endStationCode = endStationCode;
    }

    public String getDepartStationCode() {
        return departStationCode;
    }

    public void setDepartStationCode(String departStationCode) {
        this.departStationCode = departStationCode;
    }

    public String getArriveStationCode() {
        return arriveStationCode;
    }

    public void setArriveStationCode(String arriveStationCode) {
        this.arriveStationCode = arriveStationCode;
    }

    public String getDepartTime() {
        return departTime;
    }

    public void setDepartTime(String departTime) {
        this.departTime = departTime;
    }

    public String getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(String arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getSpendTime() {
        return spendTime;
    }

    public void setSpendTime(String spendTime) {
        this.spendTime = spendTime;
    }

    public Integer getSoftSeatLeft() {
        return softSeatLeft;
    }

    public void setSoftSeatLeft(Integer softSeatLeft) {
        this.softSeatLeft = softSeatLeft;
    }

    public Integer getNoSeatLeft() {
        return noSeatLeft;
    }

    public void setNoSeatLeft(Integer noSeatLeft) {
        this.noSeatLeft = noSeatLeft;
    }

    public Integer getHardBedLeft() {
        return hardBedLeft;
    }

    public void setHardBedLeft(Integer hardBedLeft) {
        this.hardBedLeft = hardBedLeft;
    }

    public Integer getHardSeatLeft() {
        return hardSeatLeft;
    }

    public void setHardSeatLeft(Integer hardSeatLeft) {
        this.hardSeatLeft = hardSeatLeft;
    }

    public Integer getSecondSeatLeft() {
        return secondSeatLeft;
    }

    public void setSecondSeatLeft(Integer secondSeatLeft) {
        this.secondSeatLeft = secondSeatLeft;
    }

    public Integer getFirstSeatLeft() {
        return firstSeatLeft;
    }

    public void setFirstSeatLeft(Integer firstSeatLeft) {
        this.firstSeatLeft = firstSeatLeft;
    }

    public Integer getBusinessSeatLeft() {
        return businessSeatLeft;
    }

    public void setBusinessSeatLeft(Integer businessSeatLeft) {
        this.businessSeatLeft = businessSeatLeft;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getDatachangeTime() {
        return datachangeTime;
    }

    public void setDatachangeTime(Date datachangeTime) {
        this.datachangeTime = datachangeTime;
    }

}

