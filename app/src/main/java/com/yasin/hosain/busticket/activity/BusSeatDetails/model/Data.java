
package com.yasin.hosain.busticket.activity.BusSeatDetails.model;

import java.util.List;
import com.google.gson.annotations.Expose;

@SuppressWarnings("unused")
public class Data {

    @Expose
    private String arrivalTime;
    @Expose
    private Long availableSeats;
    @Expose
    private List<BoardingPoint> boardingPoints;
    @Expose
    private String coachNo;
    @Expose
    private String coachType;
    @Expose
    private Company company;
    @Expose
    private String date;
    @Expose
    private String departureTime;
    @Expose
    private List<DroppingPoint> droppingPoints;
    @Expose
    private String endCounter;
    @Expose
    private Fares fares;
    @Expose
    private String id;
    @Expose
    private String minimumFare;
    @Expose
    private Boolean obsolete;
    @Expose
    private Route route;
    @Expose
    private Long seatCol;
    @Expose
    private Long seatRow;
    @Expose
    private List<String> seatTypesId;
    @Expose
    private List<Seat> seats;
    @Expose
    private String startCounter;

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Long availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<BoardingPoint> getBoardingPoints() {
        return boardingPoints;
    }

    public void setBoardingPoints(List<BoardingPoint> boardingPoints) {
        this.boardingPoints = boardingPoints;
    }

    public String getCoachNo() {
        return coachNo;
    }

    public void setCoachNo(String coachNo) {
        this.coachNo = coachNo;
    }

    public String getCoachType() {
        return coachType;
    }

    public void setCoachType(String coachType) {
        this.coachType = coachType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public List<DroppingPoint> getDroppingPoints() {
        return droppingPoints;
    }

    public void setDroppingPoints(List<DroppingPoint> droppingPoints) {
        this.droppingPoints = droppingPoints;
    }

    public String getEndCounter() {
        return endCounter;
    }

    public void setEndCounter(String endCounter) {
        this.endCounter = endCounter;
    }

    public Fares getFares() {
        return fares;
    }

    public void setFares(Fares fares) {
        this.fares = fares;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMinimumFare() {
        return minimumFare;
    }

    public void setMinimumFare(String minimumFare) {
        this.minimumFare = minimumFare;
    }

    public Boolean getObsolete() {
        return obsolete;
    }

    public void setObsolete(Boolean obsolete) {
        this.obsolete = obsolete;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Long getSeatCol() {
        return seatCol;
    }

    public void setSeatCol(Long seatCol) {
        this.seatCol = seatCol;
    }

    public Long getSeatRow() {
        return seatRow;
    }

    public void setSeatRow(Long seatRow) {
        this.seatRow = seatRow;
    }

    public List<String> getSeatTypesId() {
        return seatTypesId;
    }

    public void setSeatTypesId(List<String> seatTypesId) {
        this.seatTypesId = seatTypesId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public String getStartCounter() {
        return startCounter;
    }

    public void setStartCounter(String startCounter) {
        this.startCounter = startCounter;
    }

}
