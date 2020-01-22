
package com.yasin.hosain.busticket.activity.busList.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class BusListRequestPOJO {

    @Expose
    private String date;
    @Expose
    private String fromStationId;
    @Expose
    private String toStationId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFromStationId() {
        return fromStationId;
    }

    public void setFromStationId(String fromStationId) {
        this.fromStationId = fromStationId;
    }

    public String getToStationId() {
        return toStationId;
    }

    public void setToStationId(String toStationId) {
        this.toStationId = toStationId;
    }

}
