
package com.yasin.hosain.busticket.activity.busList.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class BusData {

    @SerializedName("data")
    private List<BusDetailsDatum> mData=new ArrayList<>();
    @SerializedName("errors")
    private Object mErrors;
    @SerializedName("message")
    private Object mMessage;
    @SerializedName("timestamp")
    private Long mTimestamp;
    @SerializedName("version")
    private Double mVersion;

    public List<BusDetailsDatum> getData() {
        return mData;
    }

    public void setData(List<BusDetailsDatum> data) {
        mData = data;
    }

    public Object getErrors() {
        return mErrors;
    }

    public void setErrors(Object errors) {
        mErrors = errors;
    }

    public Object getMessage() {
        return mMessage;
    }

    public void setMessage(Object message) {
        mMessage = message;
    }

    public Long getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(Long timestamp) {
        mTimestamp = timestamp;
    }

    public Double getVersion() {
        return mVersion;
    }

    public void setVersion(Double version) {
        mVersion = version;
    }

}
