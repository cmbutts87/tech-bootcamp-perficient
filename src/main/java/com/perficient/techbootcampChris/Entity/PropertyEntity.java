package com.perficient.techbootcampChris.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "property")
public class PropertyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private int propertyNo;
	private String propertyName;
	private int rent;
	@Column(name = "landlord_id")
	private int landlordId;
	
	public PropertyEntity() {}
	
	public PropertyEntity(String propertyName, int rent, int landlordId) {
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
