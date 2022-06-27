package com.perficient.techbootcampChris.Domain;

public class Property {
	
	private int propertyNo;
	private String propertyName;
	private int rent;
	private int landlordId;
	
	public Property() {}
	
	public Property(int propertyNo, String propertyName, int rent, int landlordId) {
		this.propertyNo = propertyNo;
		this.propertyName = propertyName;
		this.rent = rent;
		this.landlordId = landlordId;
	}

	public int getPropertyNo() {
		return propertyNo;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public int getRent() {
		return rent;
	}

	public int getLandlordId() {
		return landlordId;
	}
}
