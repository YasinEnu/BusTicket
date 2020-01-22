
package com.yasin.hosain.busticket.activity.busList.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Fares {

    @SerializedName("E-Class")
    private String mEClass;

    public String getEClass() {
        return mEClass;
    }

    public void setEClass(String eClass) {
        mEClass = eClass;
    }

}
