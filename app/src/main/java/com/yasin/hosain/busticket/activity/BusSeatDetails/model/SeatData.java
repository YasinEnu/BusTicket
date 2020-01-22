
package com.yasin.hosain.busticket.activity.BusSeatDetails.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class SeatData {

    @Expose
    private Data data;
    @Expose
    private Object errors;
    @Expose
    private Object message;
    @Expose
    private Long timestamp;
    @Expose
    private Double version;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Object getErrors() {
        return errors;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

}
