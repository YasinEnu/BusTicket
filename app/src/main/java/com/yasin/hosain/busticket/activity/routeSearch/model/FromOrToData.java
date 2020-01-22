
package com.yasin.hosain.busticket.activity.routeSearch.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class FromOrToData {

    @Expose
    private String id;
    @Expose
    private String name;

    public FromOrToData(String id, String name) {
        this.id = id;
        this.name = name;
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
