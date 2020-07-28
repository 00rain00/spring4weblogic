package com.example.demo.entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Data
@ToString
@NoArgsConstructor
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

