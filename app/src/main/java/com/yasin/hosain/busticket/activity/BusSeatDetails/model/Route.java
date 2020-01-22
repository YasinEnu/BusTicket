
package com.yasin.hosain.busticket.activity.BusSeatDetails.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Route {

    @Expose
    private From from;
    @Expose
    private Boolean greenLineAccessor;
    @Expose
    private String id;
    @Expose
    private To to;

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public Boolean getGreenLineAccessor() {
        return greenLineAccessor;
    }

    public void setGreenLineAccessor(Boolean greenLineAccessor) {
        this.greenLineAccessor = greenLineAccessor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public To getTo() {
        return to;
    }

    public void setTo(To to) {
        this.to = to;
    }

}
