
package com.yasin.hosain.busticket.activity.BusSeatDetails.model;

import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class DroppingPoint {

    @Expose
    private String counterName;
    @Expose
    private Long reportingBranchId;
    @Expose
    private String reportingTime;
    @Expose
    private String scheduleTime;

    public String getCounterName() {
        return counterName;
    }

    public void setCounterName(String counterName) {
        this.counterName = counterName;
    }

    public Long getReportingBranchId() {
        return reportingBranchId;
    }

    public void setReportingBranchId(Long reportingBranchId) {
        this.reportingBranchId = reportingBranchId;
    }

    public String getReportingTime() {
        return reportingTime;
    }

    public void setReportingTime(String reportingTime) {
        this.reportingTime = reportingTime;
    }

    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

}
