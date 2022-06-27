package com.perficient.techbootcampChris.Domain;

import java.util.Collections;
import java.util.List;

public class Landlord {
	
	private int landlordId;
	private String firstName;
	private String lastName;
	private List<Property> properties;
	
	public Landlord() {
		this.properties = Collections.emptyList();
	}
		
	public Landlord(int landlordId, String firstName, String lastName) {
		this.landlordId = landlordId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.properties = Collections.emptyList();
	}
	
	public Landlord(int landlordId, String firstName, String lastName, List<Property> properties) {
		this.landlordId = landlordId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.properties = properties;
	}

	public int getLandlordId() {
		return landlordId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public List<Property> getProperties() {
		return properties;
	}
	
}
