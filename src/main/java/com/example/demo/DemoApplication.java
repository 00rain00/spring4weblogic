package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.WebApplicationInitializer;



@RestController
@SpringBootApplication
public class DemoApplication  extends SpringBootServletInitializer implements WebApplicationInitializer {


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(DemoApplication.class);
	}
	public static void main(String[] args)throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping("/hello")
    String home() {
        return "hello";
	}
	
	
}
