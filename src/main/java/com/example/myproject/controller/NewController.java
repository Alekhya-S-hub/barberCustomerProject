package com.example.myproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.model.Customers;
import com.example.myproject.service.BarberService;

@RequestMapping("/home")
@RestController
public class NewController {
	
	@Autowired
	BarberService barberService;
	
	@GetMapping("/getCurrentToken")
	public int getCurrentToken(){
		
		return barberService.getCurrentToken();
	}
	
	@GetMapping("/getTokenAndWaitingTime")
	public Customers getTokenAndWaitingTime(){
		
		return barberService.getTokenAndWaitingTime();
	}
	

	@DeleteMapping("/cancelToken")
	public String cancelToken(){
		
		return barberService.cancelToken();
	}
	
	@GetMapping("/getCustomerDetails")
	public List<Customers> getCustomerDetails()
	{
		return barberService.getCustomerDetails();
	}
	
	@GetMapping("/weeklyPeakFootFall")
	public int weeklyPeakFootFall()
	{
		return barberService.weeklyPeakFootFall();
	}
	
	@GetMapping("/avgWaitTime")
	public String avgWaitTime()
	{
		return barberService.avgWaitTime();
	}
	
	@PostMapping("/customerRegistration")
	public Map<String,Object> customerRegistration(@RequestBody Customers customer)
	{
		return barberService.customerRegistration(customer);
		
		
	}

	
	
}
