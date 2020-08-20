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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.WebApplicationInitializer;

import java.util.List;

import com.example.demo.entity.*;
import com.example.demo.services.DemoService;
import org.apache.ibatis.annotations.Param;


@Controller
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
	@GetMapping("/")
    String home() {
        return "hello";
	}
	
	@RequestMapping("/getAirportById")
	String getAirport(@Param("id" )Integer id){
		Airport airport  = service.findAirportById(id);
		String airportName = airport.getAirportName();
		return airport.toString();
	}

	@GetMapping(value="/getAllFlight")
	String getAllFlightt(Model model){
		
		List<Flight> flights = service.getAllFlight();
		
		
		model.addAttribute("flights", flights);
		return "listAll";
	
	}
	@RequestMapping("/getFlightById")
	Flight getFlight(@Param("id" )Integer id){
		Flight flight = service.getFlightById(id);
		return flight;
	}
	@RequestMapping(value="/addFlight",method = RequestMethod.POST)
	Integer insertFlight(@Param("airline" )Integer airline,@Param("departAirportid" )Integer departAirportid,@Param("arriveAirportid" )Integer arriveAirportid,
	@Param("departureTime" )String departureTime,@Param("arriveTime" )String arriveTime){
		Integer row = service.addNewFlight( airline, departAirportid, arriveAirportid, departureTime, arriveTime);
		return row;
	}

	@RequestMapping(value="/addAirport",method = RequestMethod.POST)
	Integer insertAirport(@Param("name") String name,@Param("city") String city){
		return service.addNewAirport(name, city);
	}

	@RequestMapping(value="/deleteFlightByid",method=RequestMethod.DELETE)
	boolean deleteFlightByid(@Param("id")Integer id){
		return service.deleteFlightByid(id);
	}

	@RequestMapping(value="/updateFlight", method= RequestMethod.PUT)
	Integer updateFlight(@Param("id")Integer id, @Param("attr") String attr, @Param("value") String value){
		Flight flight = service.getFlightById(id);
		switch (attr) {
			case "airline":
				flight.setAirlineid(Integer.parseInt(value));
				break;
				case "departairportid":
				flight.setdepartAirportid(Integer.parseInt(value));
				break;case "arriveairportid":
				flight.setArriveAirportid(Integer.parseInt(value));
				break;case "depaturetime":
				flight.setDeparttime(value);
				break;case "arrivetime":
				flight.setArrivetime(value);
				break;
			default:
				break;
		}

		return service.updateFlight(flight);
	}
}
