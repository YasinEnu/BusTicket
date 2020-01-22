
package com.yasin.hosain.busticket.activity.BusSeatDetails.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Seat {

    @Expose
    private String colorCode;
    @Expose
    private Object deckTitle;
    @Expose
    private String fare;
    @Expose
    private Long seatId;
    @Expose
    private String seatNo;
    @Expose
    private String seatTypeId;
    @Expose
    private String status;
    @Expose
    private Long xaxis;
    @Expose
    private Long yaxis;

    private boolean isUserSelected=false;


    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public Object getDeckTitle() {
        return deckTitle;
    }

    public void setDeckTitle(Object deckTitle) {
        this.deckTitle = deckTitle;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public String getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(String seatTypeId) {
        this.seatTypeId = seatTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getXaxis() {
        return xaxis;
    }

    public void setXaxis(Long xaxis) {
        this.xaxis = xaxis;
    }

    public Long getYaxis() {
        return yaxis;
    }

    public void setYaxis(Long yaxis) {
        this.yaxis = yaxis;
    }

    public boolean isUserSelected() {
        return isUserSelected;
    }

    public void setUserSelected(boolean userSelected) {
        isUserSelected = userSelected;
    }
}
