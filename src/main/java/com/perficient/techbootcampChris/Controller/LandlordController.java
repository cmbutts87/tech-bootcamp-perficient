package com.perficient.techbootcampChris.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perficient.techbootcampChris.Domain.Landlord;
import com.perficient.techbootcampChris.Domain.Property;
import com.perficient.techbootcampChris.Service.LandlordJpaService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class LandlordController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LandlordController.class);
	
	@Autowired
	private LandlordJpaService landlordJpaService;
	
	// Get All Entries
	@GetMapping("/landlord")
	public List<Landlord> getLandlord() {
		List<Landlord> landlords = landlordJpaService.getLandlords();
		LOGGER.info("Returning {} landlords", landlords.size());
		return landlords;
	}
	
	@GetMapping("/property")
	public List<Property> getProperty() {
		List<Property> properties = landlordJpaService.getPropertys();
		LOGGER.info("Returning {} propertys", properties.size());
		return properties;
	}
	
	// Find Methods
	// Landlord
	@GetMapping("/landlord/{landlord_id}")
	public Landlord getLandlord(@PathVariable("landlord_id") int landlordId) {
		Landlord landlord = landlordJpaService.getLandlord(landlordId);
		LOGGER.info("Returning landlord reponse with ID {}", landlord.getLandlordId());
		return landlord;
	}
	
	// Property
	@GetMapping("/property/{property_no}")
	public Property getProperty(@PathVariable("property_no") int propertyNo) {
		Property property = landlordJpaService.getProperty(propertyNo);
		LOGGER.info("Returning property reponse with ID {}", property.getPropertyNo());
		return property;
	}
	
	@GetMapping("/property/rent/{rent}")
	public List<Property> getPropertyById(@PathVariable("rent") int rent) {
		List<Property> properties = landlordJpaService.getPropertyByRent(rent);
		LOGGER.info("Returning {} propertys with rent lower than {}", properties.size(), rent);
		return properties;
	
	}
	
	// Create Entry
	@PostMapping("landlord")
	public Landlord createLandlord(@RequestBody Landlord landlord) {
		LOGGER.info("Creating landlord with ID {}", landlord.getLandlordId());
		return landlordJpaService.createLandlord(landlord);
	}
	
	@PostMapping("property")
	public Property createProperty(@RequestBody Property property) {
		LOGGER.info("Creating property with ID {}", property.getPropertyNo());
		return landlordJpaService.createProperty(property);
	}
}
