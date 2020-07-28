package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.WebApplicationInitializer;
import com.example.demo.entity.*;
import com.example.demo.services.*;
import org.apache.ibatis.annotations.Param;


@RestController
@SpringBootApplication
public class DemoApplication  extends SpringBootServletInitializer implements WebApplicationInitializer {
	@Autowired
	private DemoService service;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(DemoApplication.class);
	}
	public static void main(String[] args)throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping("/")
    String home() {
        return "hello";
	}
	
	@RequestMapping("/getAirportById")
	String getAirport(@Param("id" )Integer id){
		Airport airport  = service.findAirportById(id);
		String airportName = airport.getAirportName();
		return airport.toString();
	}

	@RequestMapping("/getAirportByAirportName")
	String getAirportByAirportName(@Param("name" )String name){
		
		
		String s = service.findAirportByCity(name);
		return  s;
	}
}
