package com.example.demo.entity;

import java.io.Serializable;

public class Airport implements Serializable {
    private Integer idAirport;
    private String  AirportName;
    private String AirportCity;

    public Integer getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(Integer idAirport) {
        this.idAirport = idAirport;
    }

    public String getAirportName() {
        return AirportName;
    }

    public void setAirportName(String airportName) {
        AirportName = airportName;
    }

    public String getAirportCity() {
        return AirportCity;
    }

    public void setAirportCity(String airportCity) {
        AirportCity = airportCity;
    }

    @Override
    public String toString() {
        return "Airport [AirportCity=" + AirportCity + ", AirportName=" + AirportName + ", idAirport=" + idAirport
                + "]";
    }

    // @Override
    // public String toString(){
    //     return idAirport.get
    // }
}