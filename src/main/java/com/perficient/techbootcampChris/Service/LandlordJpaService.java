package com.perficient.techbootcampChris.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.perficient.techbootcampChris.Domain.Landlord;
import com.perficient.techbootcampChris.Domain.Property;
import com.perficient.techbootcampChris.Entity.LandlordEntity;
import com.perficient.techbootcampChris.Entity.PropertyEntity;

@Service
public class LandlordJpaService {
	
	@Autowired
	LandlordRepository landlordRepository;
	@Autowired
	PropertyRepository propertyRepository;
	
	// Create New Entities
	public Landlord createLandlord(Landlord landlord) {
		List<PropertyEntity> properties = new ArrayList<>();
		LandlordEntity le = new LandlordEntity(landlord.getFirstName(), landlord.getLastName(), properties);
		if(!CollectionUtils.isEmpty(landlord.getProperties())) {
			landlord.getProperties().forEach(property ->
			{
				if(property.getPropertyNo() != 0) {
					Optional<PropertyEntity> existingProperty = propertyRepository.findById(property.getPropertyNo());
					if(existingProperty.isPresent()) {
						properties.add(existingProperty.get());
					} else {
						properties.add(new PropertyEntity(property.getPropertyName(), property.getRent(), property.getLandlordId()));
					}
				}
			});
		}
		le = landlordRepository.save(le);
		return map(le);
	}
	
	public Property createProperty(Property property) {
		PropertyEntity pe = new PropertyEntity(property.getPropertyName(), property.getRent(), property.getLandlordId());
		pe = propertyRepository.save(pe);
		return map(pe);
	}
	
	// Get All Entries
	public List<Property> getPropertys() {
		Iterable<PropertyEntity> propertyEntities = propertyRepository.findAll();
		return StreamSupport.stream(propertyEntities.spliterator(), false).map(pe -> map(pe)).collect(Collectors.toList());
	}
	
	public List<Landlord> getLandlords() {
		Iterable<LandlordEntity> landlordEntities = landlordRepository.findAll();
		return StreamSupport.stream(landlordEntities.spliterator(), false).map(le -> map(le)).collect(Collectors.toList());
	}
	
	// Find Entries
	public Landlord getLandlord(int landlordId) {
		Optional<LandlordEntity> landlordEntity = landlordRepository.findById(landlordId);
		
		if(landlordEntity.isPresent()) {
			return map(landlordEntity.get());
		} else {
			return null;
		}
	}
	
	public Property getProperty(int propertyNo) {
		Optional<PropertyEntity> propertyEntity = propertyRepository.findById(propertyNo);
		
		if(propertyEntity.isPresent()) {
			return map(propertyEntity.get());
		} else {
			return null;
		}
	}
	
	public List<Property> getPropertyByRent(int rent) {
		Iterable<PropertyEntity> propertyEntities = propertyRepository.findByRent(rent);
		return StreamSupport.stream(propertyEntities.spliterator(), false).map(pe -> map(pe)).collect(Collectors.toList());
	}
	
	// Mapping Functions
	private Landlord map(LandlordEntity le) {
		return new Landlord(le.getLandlordId(), le.getFirstName(), le.getLastName(),
				le.getProperties().stream().map(pe -> map(pe)).collect(Collectors.toList()));
	}
	
	private Property map(PropertyEntity pe) {
		return new Property(pe.getPropertyNo(), pe.getPropertyName(), pe.getRent(), pe.getLandlordId());
	} 
}
