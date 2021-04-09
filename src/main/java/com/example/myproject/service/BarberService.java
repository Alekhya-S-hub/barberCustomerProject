package com.example.myproject.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject.model.BarberCustomers;
import com.example.myproject.model.Customers;
import com.example.myproject.repository.BarberRepository;
import com.example.myproject.repository.CustomerRepository;

@Service
public class BarberService {

	@Autowired
	BarberRepository barberRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	public int getCurrentToken() {
		
	return	barberRepository.findLargestToken();
	
	}

	public Customers getTokenAndWaitingTime() {
		
		return customerRepository.getTokenAndWaitingTime();
	}

	public String cancelToken() {
		
		return customerRepository.deleteByTokenId();
	}

	public List<Customers> getCustomerDetails() {
		
		List<Customers> customers = new ArrayList<>();
		customers= customerRepository.findAll();
		return customers;
	}

	public String avgWaitTime() {
		
		return customerRepository.avgWaitTime();
	}

	public int weeklyPeakFootFall() {
		
		return customerRepository.countByCustomerLeft();
	}

	public Map<String, Object> customerRegistration(Customers customer) {
		
		
		Customers addCust = new Customers();
		Map<String, Object> result = new HashMap<>();
		BarberCustomers bar = new BarberCustomers();
		try {		

		int b= barberRepository.findFreeBarbers();
		
		if(b != 0)
		{
			
			int token = barberRepository.findLargestToken()+1;
			bar.setTokenId(token);
			bar.setBarberId(b);
			bar.setBarberEngaged(true);
			barberRepository.save(bar);
			
			
		}
		
		else {
		int token = barberRepository.findLargestToken()+1;
		int chairNum= customerRepository.findLargestChairNumber()+1;
		addCust.setCustomerName(customer.getCustomerName());
		if(chairNum>10)		
		{
			addCust.setCustomerLeft(true);
			//addCust.setWaitingTime(15);
			customerRepository.save(addCust);
			result.put("status","customer can leave");
			return result;
		}
		addCust.setTokenId(token);
		addCust.setWaitingChair(chairNum);		
		customerRepository.save(addCust);
		result.put("status","customer is waiting");
		}
		
		TestSleepMethod1 t1=new TestSleepMethod1();
		t1.start();  
		bar.setBarberEngaged(false);
		barberRepository.save(bar);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}
	class TestSleepMethod1 extends Thread{  
		 public void run(){  
		  for(int i=1;i<5;i++){  
		    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}  
		    System.out.println(i);  
		  }  
		 }
	}


