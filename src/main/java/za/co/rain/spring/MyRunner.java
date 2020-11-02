package za.co.rain.spring;

import java.time.OffsetDateTime;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import za.co.rain.spring.model.Individual;
import za.co.rain.spring.repository.IndividualRepository;

@Component 
public class MyRunner implements CommandLineRunner { 
	
	private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

	@Autowired
	private IndividualRepository repository;

	@Override
	@Transactional
	public void run(String... strings) throws Exception { 
		
		logger.info("initializing Individuals...");
		
		
		repository.save(new Individual("href1", "aristocraticTitle1", OffsetDateTime.now(), "countryOfBirth1",
				OffsetDateTime.now(), "familyName1", "fullName1", "gender1", "baseType1",
				"schemaLocation1", "type1"));
		repository.save(new Individual("href2", "aristocraticTitle2", OffsetDateTime.now(), "countryOfBirth2",
				OffsetDateTime.now(), "familyName2", "fullName2", "gender2", "baseType2",
				"schemaLocation2", "type2"));
		repository.save(new Individual("href3", "aristocraticTitle3", OffsetDateTime.now(), "countryOfBirth3",
				OffsetDateTime.now(), "familyName3", "fullName3", "gender3", "baseType3",
				"schemaLocation3", "type3"));
		
		logger.info("Done initializing Individuals...");
	}
}