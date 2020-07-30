package com.example.demo.entity;


import java.io.Serializable;

public class Airline implements Serializable {
    Integer idAirline;
    String AirlineName;

    public Integer getIdAirline() {
        return idAirline;
    }

    public void setIdAirline(Integer idAirline) {
        this.idAirline = idAirline;
    }

    public String getAirlineName() {
        return AirlineName;
    }

    public void setAirlineName(String airlineName) {
        AirlineName = airlineName;
    }

    @Override
    public String toString() {
        return "Airline [AirlineName=" + AirlineName + ", idAirline=" + idAirline + "]";
    }
}

