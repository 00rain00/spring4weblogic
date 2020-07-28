package com.example.demo.services;
import com.example.demo.entity.*;
public interface DemoService {
    Airport findAirportById (Integer id);
    String findAirportByCity(String city);
    
}