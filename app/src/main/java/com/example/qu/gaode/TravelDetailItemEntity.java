package com.example.qu.gaode;

/**
 * Created by Administrator on 2015/7/15.
 */
public class TravelDetailItemEntity extends ResponseEntity {
    private String gpsFlag;
    private String gpsTime;
    private String gsmPosLac;
    private String mnc;
    private String obdSpeed;
    private String posJing;
    private String posWei;
    private String trkId;

    public String getGpsFlag() {
        return gpsFlag;
    }

    public void setGpsFlag(String gpsFlag) {
        this.gpsFlag = gpsFlag;
    }

    public String getGpsTime() {
        return gpsTime;
    }

    public void setGpsTime(String gpsTime) {
        this.gpsTime = gpsTime;
    }

    public String getGsmPosLac() {
        return gsmPosLac;
    }

    public void setGsmPosLac(String gsmPosLac) {
        this.gsmPosLac = gsmPosLac;
    }

    public String getMnc() {
        return mnc;
    }

    public void setMnc(String mnc) {
        this.mnc = mnc;
    }

    public String getObdSpeed() {
        return obdSpeed;
    }

    public void setObdSpeed(String obdSpeed) {
        this.obdSpeed = obdSpeed;
    }

    public String getPosJing() {
        return posJing;
    }

    public void setPosJing(String posJing) {
        this.posJing = posJing;
    }

    public String getPosWei() {
        return posWei;
    }

    public void setPosWei(String posWei) {
        this.posWei = posWei;
    }

    public String getTrkId() {
        return trkId;
    }

    public void setTrkId(String trkId) {
        this.trkId = trkId;
    }
}