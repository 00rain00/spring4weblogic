package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Airport;
import com.example.demo.entity.Flight;
import com.example.demo.mapper.AirportMapper;
import com.example.demo.mapper.FlightMapper;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private AirportMapper airportMapper;

    @Autowired
    private FlightMapper flightMapper;

    @Override
    public Airport findAirportById(Integer id) {
        return airportMapper.findById(id);

    }

    @Override
    public String findAirportByCity(String city) {

        return airportMapper.findByCity(city).toString();
    }

    @Override
    public List<Flight> getAllFlight() {
      return   flightMapper.findAll();
        
    }

    @Override
    public Integer addNewFlight( Integer AirlineID, Integer DepartAirportID, Integer ArriveAirportID,
            String DepartureTime, String ArriveTime) {
          
        return  flightMapper.insertFlight(AirlineID,DepartAirportID,ArriveAirportID,DepartureTime,ArriveTime);
    }

    @Override
    public Flight getFlightById(Integer id) {
        
        return flightMapper.findById(id);
    }

    @Override
    public Integer addNewAirport(String name, String city) {
        
        return airportMapper.insertAirport(name, city);
    }

    @Override
    public Integer updateFlight(Flight flight) {
        



        return flightMapper.updateFlight(flight);
    }

    @Override
    public boolean deleteFlightByid(Integer id) {
        
        return flightMapper.deleteFlightbyid(id);
    }
    
}