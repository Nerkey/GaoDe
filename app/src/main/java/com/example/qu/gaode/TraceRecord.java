package com.example.qu.gaode;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 用户的轨迹信息entity
 *
 * @author Jeffery Leng
 */
public class TraceRecord implements Serializable {

    private String traceId;
    private String startLocate;
    private String endLocate;
    private String startTime;
    private String endTime;
    private Integer avgSpeed;
    private Integer oilL;
    private Integer cost;
    private BigDecimal km;
    private Double avgOilSpend;//平均油耗
    private String carPassedTime;//行车时长
    private int totalRecords;


    public Double getAvgOilSpend() {
        return avgOilSpend;
    }

    public void setAvgOilSpend(Double avgOilSpend) {
        this.avgOilSpend = avgOilSpend;
    }

    public String getCarPassedTime() {
        return carPassedTime;
    }

    public void setCarPassedTime(String carPassedTime) {
        this.carPassedTime = carPassedTime;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getStartLocate() {
        return startLocate;
    }

    public void setStartLocate(String startLocate) {
        this.startLocate = startLocate;
    }

    public String getEndLocate() {
        return endLocate;
    }

    public void setEndLocate(String endLocate) {
        this.endLocate = endLocate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getAvgSpeed() {
        return avgSpeed;
    }

    public void setAvgSpeed(Integer avgSpeed) {
        this.avgSpeed = avgSpeed;
    }

    public Integer getOilL() {
        return oilL;
    }

    public void setOilL(Integer oilL) {
        this.oilL = oilL;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public BigDecimal getKm() {
        return km;
    }

    public void setKm(BigDecimal km) {
        this.km = km;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }


}
