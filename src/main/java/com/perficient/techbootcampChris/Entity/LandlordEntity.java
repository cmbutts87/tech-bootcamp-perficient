package com.perficient.techbootcampChris.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity(name = "landlord")
public class LandlordEntity {

	// Custom Generator to start creating IDs at 100
	@GenericGenerator(
		name = "id-generator",
		strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters = {
			@Parameter(name = "sequence_name", value = "user_sequence"),
			@Parameter(name = "initial_value", value = "100"),
			@Parameter(name = "increment_size", value = "1")
		})
	
	@Id
	@Column(name="id")
	@GeneratedValue(generator = "id-generator")	
	private int landlordId;
	
	private String firstName;
	private String lastName;
	
	// Joining landlords to their properties based on landlord_id
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="landlord_id")
	private List<PropertyEntity> properties;
	
	public LandlordEntity() {}
	
	public LandlordEntity(String firstName, String lastName, List<PropertyEntity> properties) {
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
	
	public List<PropertyEntity> getProperties() {
		return properties;
	}
}
