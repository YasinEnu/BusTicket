
package com.yasin.hosain.busticket.activity.busList.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Route {

    @SerializedName("from")
    private From mFrom;
    @SerializedName("greenLineAccessor")
    private Boolean mGreenLineAccessor;
    @SerializedName("id")
    private String mId;
    @SerializedName("to")
    private To mTo;

    public From getFrom() {
        return mFrom;
    }

    public void setFrom(From from) {
        mFrom = from;
    }

    public Boolean getGreenLineAccessor() {
        return mGreenLineAccessor;
    }

    public void setGreenLineAccessor(Boolean greenLineAccessor) {
        mGreenLineAccessor = greenLineAccessor;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public To getTo() {
        return mTo;
    }

    public void setTo(To to) {
        mTo = to;
    }

}
