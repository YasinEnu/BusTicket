
package com.yasin.hosain.busticket.activity.BusSeatDetails.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Fares {

    @SerializedName("E-Class")
    private String eClass;

    public String getEClass() {
        return eClass;
    }

    public void setEClass(String eClass) {
        this.eClass = eClass;
    }

}
