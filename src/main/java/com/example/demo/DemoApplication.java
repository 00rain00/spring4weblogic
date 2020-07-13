package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;



import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)throws Exception {
		SpringApplication.run(DemoApplication.class, args);
	}
	@RequestMapping("/hello")
    String home() {
        return "hello";
	}
	
	
}
