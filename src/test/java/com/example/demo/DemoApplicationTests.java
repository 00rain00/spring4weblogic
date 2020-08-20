package com.example.demo;

import com.example.demo.services.DemoService;
import com.sun.tools.sjavac.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import com.example.demo.entity.Flight;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
@MockBean
private DemoService service;
@Autowired
private DemoApplication app;

	@Test
	public void contextLoads() {
		
	}

}
