package com.perficient.techbootcampChris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EntityScan(basePackages = "com.perficient.techbootcampChris.Entity")
public class TechbootcampChrisApplication {

	private static final Logger log = LoggerFactory.getLogger(TechbootcampChrisApplication.class);
	
	public static void main(String[] args) {
		
		log.info("info message");
		log.debug("debugging");

		SpringApplication.run(TechbootcampChrisApplication.class, args);
	}

}
