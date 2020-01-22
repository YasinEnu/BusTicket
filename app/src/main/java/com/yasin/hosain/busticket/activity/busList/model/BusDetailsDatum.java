
package com.yasin.hosain.busticket.activity.busList.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class BusDetailsDatum {

    @SerializedName("arrivalTime")
    private String mArrivalTime;
    @SerializedName("availableSeats")
    private Long mAvailableSeats;
    @SerializedName("boardingPoints")
    private Object mBoardingPoints;
    @SerializedName("coachNo")
    private String mCoachNo;
    @SerializedName("coachType")
    private String mCoachType;
    @SerializedName("company")
    private Company mCompany;
    @SerializedName("date")
    private String mDate;
    @SerializedName("departureTime")
    private String mDepartureTime;
    @SerializedName("droppingPoints")
    private Object mDroppingPoints;
    @SerializedName("endCounter")
    private String mEndCounter;
    @SerializedName("fares")
    private Fares mFares;
    @SerializedName("id")
    private String mId;
    @SerializedName("minimumFare")
    private String mMinimumFare;
    @SerializedName("obsolete")
    private Boolean mObsolete;
    @SerializedName("route")
    private Route mRoute;
    @SerializedName("seatCol")
    private Long mSeatCol;
    @SerializedName("seatRow")
    private Long mSeatRow;
    @SerializedName("seatTypesId")
    private List<String> mSeatTypesId;
    @SerializedName("seats")
    private Object mSeats;
    @SerializedName("startCounter")
    private String mStartCounter;

    public String getArrivalTime() {
        return mArrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        mArrivalTime = arrivalTime;
    }

    public Long getAvailableSeats() {
        return mAvailableSeats;
    }

    public void setAvailableSeats(Long availableSeats) {
        mAvailableSeats = availableSeats;
    }

    public Object getBoardingPoints() {
        return mBoardingPoints;
    }

    public void setBoardingPoints(Object boardingPoints) {
        mBoardingPoints = boardingPoints;
    }

    public String getCoachNo() {
        return mCoachNo;
    }

    public void setCoachNo(String coachNo) {
        mCoachNo = coachNo;
    }

    public String getCoachType() {
        return mCoachType;
    }

    public void setCoachType(String coachType) {
        mCoachType = coachType;
    }

    public Company getCompany() {
        return mCompany;
    }

    public void setCompany(Company company) {
        mCompany = company;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public String getDepartureTime() {
        return mDepartureTime;
    }

    public void setDepartureTime(String departureTime) {
        mDepartureTime = departureTime;
    }

    public Object getDroppingPoints() {
        return mDroppingPoints;
    }

    public void setDroppingPoints(Object droppingPoints) {
        mDroppingPoints = droppingPoints;
    }

    public String getEndCounter() {
        return mEndCounter;
    }

    public void setEndCounter(String endCounter) {
        mEndCounter = endCounter;
    }

    public Fares getFares() {
        return mFares;
    }

    public void setFares(Fares fares) {
        mFares = fares;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getMinimumFare() {
        return mMinimumFare;
    }

    public void setMinimumFare(String minimumFare) {
        mMinimumFare = minimumFare;
    }

    public Boolean getObsolete() {
        return mObsolete;
    }

    public void setObsolete(Boolean obsolete) {
        mObsolete = obsolete;
    }

    public Route getRoute() {
        return mRoute;
    }

    public void setRoute(Route route) {
        mRoute = route;
    }

    public Long getSeatCol() {
        return mSeatCol;
    }

    public void setSeatCol(Long seatCol) {
        mSeatCol = seatCol;
    }

    public Long getSeatRow() {
        return mSeatRow;
    }

    public void setSeatRow(Long seatRow) {
        mSeatRow = seatRow;
    }

    public List<String> getSeatTypesId() {
        return mSeatTypesId;
    }

    public void setSeatTypesId(List<String> seatTypesId) {
        mSeatTypesId = seatTypesId;
    }

    public Object getSeats() {
        return mSeats;
    }

    public void setSeats(Object seats) {
        mSeats = seats;
    }

    public String getStartCounter() {
        return mStartCounter;
    }

    public void setStartCounter(String startCounter) {
        mStartCounter = startCounter;
    }

}
