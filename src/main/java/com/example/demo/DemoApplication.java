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
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
	return application.sources(DemoApplication.class);
	}
	public static void main(final String[] args)throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}
	@GetMapping("/")
    String home() {
        return "hello";
	}
	@GetMapping("/signup")
	String showSignupForm(final Flight flight){
		return "addFlight";
	}
	@GetMapping("/search")
	String showSearchForm(Flight flight){

		return "searchFlight";
	}
	@PostMapping("/searchFlight")
	String showSearchResult(Model model,Flight flight){
		
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println(flight.toString());
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		List<Flight> flights = service.searchFlights(flight);
		for (Flight flight2 : flights) {
			System.out.println(flight2.toString());
		}
		model.addAttribute("flights", flights);

		return "listAll";
	}
	
	@RequestMapping("/getAirportById")
	String getAirport(@Param("id" ) final Integer id){
		final Airport airport  = service.findAirportById(id);
		final String airportName = airport.getAirportName();
		return airport.toString();
	}

	@GetMapping(value="/getAllFlight")
	String getAllFlightt(final Model model){
		
		final List<Flight> flights = service.getAllFlight();
		
		
		model.addAttribute("flights", flights);
		return "listAll";
	
	}
	@RequestMapping("/getFlightById")
	Flight getFlight(@Param("id" ) final Integer id){
		final Flight flight = service.getFlightById(id);
		return flight;
	}
	// @PostMapping(value="/addFlight")
	// Integer insertFlight(@Param("airline" )Integer airline,@Param("departAirportid" )Integer departAirportid,@Param("arriveAirportid" )Integer arriveAirportid,
	// @Param("departureTime" )String departureTime,@Param("arriveTime" )String arriveTime){
	// 	Integer row = service.addNewFlight( airline, departAirportid, arriveAirportid, departureTime, arriveTime);
	// 	return row;
	// }
	@PostMapping("/addFlight")
    public String addUser(final Flight flight, final Model model) {
       
        
       service.addNewFlight(flight);
        model.addAttribute("flights", service.getAllFlight());
        return "redirect:/getAllFlight";
    }


	@RequestMapping(value="/addAirport",method = RequestMethod.POST)
	Integer insertAirport(@Param("name") final String name,@Param("city") final String city){
		return service.addNewAirport(name, city);
	}

	@RequestMapping(value="/deleteFlightByid",method=RequestMethod.DELETE)
	boolean deleteFlightByid(@Param("id") final Integer id){
		return service.deleteFlightByid(id);
	}
	@PostMapping(value="/updateFlight/{id}" )
public String updateFlight(@PathVariable("id")  Integer id,  Flight flight, 
    Model model) {
		
		flight.setIdFlight(id);
    service.updateFlight(flight);
        
    
    model.addAttribute("flights", service.getAllFlight());
    return "redirect:/getAllFlight";
}
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") final Integer id, final Model model) {
		final Flight flight = service.getFlightById(id);
		  
		
		model.addAttribute("flight",flight);
		return "updateFlight";
	}
	@GetMapping("/delete/{id}")
public String deleteFlight(@PathVariable("id") Integer id, Model model) {
    Flight flight = service.getFlightById(id);
     
    service.deleteFlightByid(id);
    model.addAttribute("flights", service.getAllFlight());
    return "listAll";
}



	// @RequestMapping(value="/updateFlight", method= RequestMethod.PUT)
	// Integer updateFlight(@Param("id")Integer id, @Param("attr") String attr, @Param("value") String value){
	// 	Flight flight = service.getFlightById(id);
	// 	switch (attr) {
	// 		case "airline":
	// 			flight.setAirlineid(Integer.parseInt(value));
	// 			break;
	// 			case "departairportid":
	// 			flight.setdepartAirportid(Integer.parseInt(value));
	// 			break;case "arriveairportid":
	// 			flight.setArriveAirportid(Integer.parseInt(value));
	// 			break;case "depaturetime":
	// 			flight.setDeparttime(value);
	// 			break;case "arrivetime":
	// 			flight.setArrivetime(value);
	// 			break;
	// 		default:
	// 			break;
	// 	}

	// 	return service.updateFlight(flight);
	// }
}
