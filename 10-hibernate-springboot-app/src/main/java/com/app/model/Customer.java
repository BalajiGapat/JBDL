package com.app.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer 
{
	@Id
	private int id;
	private String custName;
	
	@Embedded
	private Address address;

	public Customer() 
	{
		super();
	}

	public Customer(int id, String custName, Address address) 
	{
		super();
		this.id = id;
		this.custName = custName;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "Customer [id=" + id + ", custName=" + custName + ", address=" + address + "]";
	}
	
	
	
	
}
