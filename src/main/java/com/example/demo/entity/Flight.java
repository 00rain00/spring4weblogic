package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Flight implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6411083089391625857L;
    private Integer idFlight;
    private Integer airlineid;
    private Integer departAirportid;
    private Integer arriveAirportid;
    private  String departuretime;
    private String arrivetime;

    

    public Integer getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(Integer idFlight) {
        this.idFlight = idFlight;
    }

    public Integer getAirlineid() {
        return airlineid;
    }

    public void setAirlineid(Integer airlineid) {
        this.airlineid = airlineid;
    }

    public Integer getdepartAirportid() {
        return departAirportid;
    }

    public void setdepartAirportid(Integer departAirportid) {
        this.departAirportid = departAirportid;
    }

    public Integer getArriveAirportid() {
        return arriveAirportid;
    }

    public void setArriveAirportid(Integer arriveAirportid) {
        this.arriveAirportid = arriveAirportid;
    }

    public String getDeparttime() {
        return departuretime;
    }

    public void setDeparttime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getArrivetime() {
        return arrivetime;
    }

    public void setArrivetime(String arrivetime) {
        this.arrivetime = arrivetime;
    }

    @Override
    public String toString() {
        return "Flight [airlineid=" + airlineid + ", arriveAirportid=" + arriveAirportid + ", arrivetime=" + arrivetime
                + ", departAirportid=" + departAirportid + ", departuretime=" + departuretime + ", idFlight=" + idFlight + "]";
    }
}