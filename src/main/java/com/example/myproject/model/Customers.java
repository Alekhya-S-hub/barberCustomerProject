package com.example.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	private String customerName;
	@Column(name="token_id")
	private int tokenId=0;
	private int waitingTime;
	private boolean isBarberChair;
	private int waitingChair;
	private boolean customerLeft;
	
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getTokenId() {
		return tokenId;
	}
	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}
	public int getWaitingTime() {
		return waitingTime;
	}
	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}
	public boolean isBarberChair() {
		return isBarberChair;
	}
	public void setBarberChair(boolean isBarberChair) {
		this.isBarberChair = isBarberChair;
	}
	public int getWaitingChair() {
		return waitingChair;
	}
	public void setWaitingChair(int waitingChair) {
		this.waitingChair = waitingChair;
	}
	public boolean isCustomerLeft() {
		return customerLeft;
	}
	public void setCustomerLeft(boolean customerLeft) {
		this.customerLeft = customerLeft;
	}

}
