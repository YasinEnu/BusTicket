
package com.yasin.hosain.busticket.activity.routeSearch.model;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class FromOrToCityModel {

    @Expose
    private List<FromOrToData> data;
    @Expose
    private Object errors;
    @Expose
    private Object message;
    @Expose
    private Long timestamp;
    @Expose
    private Double version;

    public List<FromOrToData> getData() {
        return data;
    }

    public void setData(List<FromOrToData> data) {
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
