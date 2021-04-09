package com.example.myproject.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="barber_customers")
public class BarberCustomers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="barber_id")
	private int barberId;
	@Column(name="customer_id")
	private int customerId;
	@Column(name="token_id")
	private int tokenId;
	@Column(name="is_barber_engaged" ,nullable = false)
	private boolean isBarberEngaged;
	@OneToOne
	private BarberMaster bM;
	@OneToOne
	private BarberCustomers bC;
	
	public int getBarberId() {
		return barberId;
	}
	public void setBarberId(int barberId) {
		this.barberId = barberId;
	}
	
	public int getTokenId() {
		return tokenId;
	}
	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}
	public boolean isBarberEngaged() {
		return isBarberEngaged;
	}
	public void setBarberEngaged(boolean isBarberEngaged) {
		this.isBarberEngaged = isBarberEngaged;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BarberMaster getbM() {
		return bM;
	}
	public void setbM(BarberMaster bM) {
		this.bM = bM;
	}
	public BarberCustomers getbC() {
		return bC;
	}
	public void setbC(BarberCustomers bC) {
		this.bC = bC;
	}
	
	

}
