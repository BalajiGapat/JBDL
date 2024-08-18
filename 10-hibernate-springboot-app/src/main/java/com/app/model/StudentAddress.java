package com.app.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentAddress 
{
	private String flatNo;
	private String placeName;
	
	public StudentAddress() 
	{
		super();
	}

	public StudentAddress(String flatNo, String placeName) {
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

	@Override
	public String toString() {
		return "StudentAddress [flatNo=" + flatNo + ", placeName=" + placeName + "]";
	}
	
	
}
