package com.perficient.techbootcampChris.Config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.perficient.techbootcampChris.Domain.Landlord;
import com.perficient.techbootcampChris.Domain.Property;
import com.perficient.techbootcampChris.Service.LandlordJpaService;

@Configuration
public class InitData {

		@Autowired
		private LandlordJpaService landlordJpaService;
		
		@PostConstruct
		private void init() {
			landlordJpaService.createLandlord(new Landlord(-1, "Fredrick", "Bellbottom"));
			landlordJpaService.createLandlord(new Landlord(-1, "Carolynne", "Spencer"));
			landlordJpaService.createLandlord(new Landlord(-1, "The", "Rat King"));
			
			// Landlord ID 10000
			landlordJpaService.createProperty(new Property(-1, "214 Westwood Lane", 1200, 100));
			landlordJpaService.createProperty(new Property(-1, "Skyridge Acres", 2000, 100));
			landlordJpaService.createProperty(new Property(-1, "Westwood Brink", 1300, 100));
			landlordJpaService.createProperty(new Property(-1, "916 Westwood Lane", 800, 100));
			
			// Landlord ID 10001
			landlordJpaService.createProperty(new Property(-1, "Hunnington Heights",2500, 101));
			landlordJpaService.createProperty(new Property(-1, "The Loft", 2100, 101));
			landlordJpaService.createProperty(new Property(-1, "100 West Hubert", 1600, 101));
			
			// Landlord ID 10002
			
			landlordJpaService.createProperty(new Property(-1, "The Rat Hole", 1, 102));
			
		}
}
