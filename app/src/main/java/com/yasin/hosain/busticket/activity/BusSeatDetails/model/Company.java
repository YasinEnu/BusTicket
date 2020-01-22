
package com.yasin.hosain.busticket.activity.BusSeatDetails.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Company {

    @Expose
    private String companySKU;
    @Expose
    private String id;
    @Expose
    private String name;

    public String getCompanySKU() {
        return companySKU;
    }

    public void setCompanySKU(String companySKU) {
        this.companySKU = companySKU;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
