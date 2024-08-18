package com.app.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address 
{
	private String flatNo;
	private String placeName;
	
	public Address() 
	{
		super();
	}
	
	public Address(String flatNo, String placeName) 
	{
		super();
		this.flatNo = flatNo;
		this.placeName = placeName;
	}

	public String getFlatNo() {
		return flatNo;
	}
	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	
	
	
	
}
