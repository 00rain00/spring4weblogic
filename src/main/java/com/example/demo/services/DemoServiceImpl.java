package com.example.demo.services;

import com.example.demo.entity.Airport;
import com.example.demo.mapper.AirportMapper;
import com.example.demo.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private AirportMapper airportMapper;


    @Override
    public Airport findAirportById(Integer id) {
       return  airportMapper.findById(id);
       
    }

    @Override
    public String findAirportByCity(String city) {
        
        return airportMapper.findByCity(city).toString();
    }
    
}