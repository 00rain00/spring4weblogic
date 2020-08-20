package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.*;
public interface DemoService {
    Airport findAirportById (Integer id);
    String findAirportByCity(String city);
    List<Flight> getAllFlight();
    Integer addNewFlight( Integer AirlineID, Integer DepartAirportID, Integer ArriveAirportID, String DepartureTime, String ArriveTime );
    Integer addNewFlight(Flight flight);
    Flight getFlightById(Integer id);
    Integer addNewAirport(String name,String city);
   Integer updateFlight(Flight flight);
    boolean deleteFlightByid(Integer id);
   List<Flight>searchFlights(Flight flight);
   
   
}