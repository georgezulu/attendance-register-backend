package za.co.rain.spring.utils;

import za.co.rain.spring.model.Individual;

public class ApiUtililities {
	
	public static Individual setNewValues(Individual individual, Individual individualDetails) {
		
		if (individualDetails.getHref() != null) {
		individual.setHref(individualDetails.getHref());
		}
		if (individualDetails.getAristocraticTitle() != null) {
		individual.setAristocraticTitle(individualDetails.getAristocraticTitle());
		}
		if (individualDetails.getBirthDate() != null) {
		individual.setBirthDate(individualDetails.getBirthDate());
		}
		if (individualDetails.getCountryOfBirth() != null) {
		individual.setCountryOfBirth(individualDetails.getCountryOfBirth());
		}
		if (individualDetails.getDeathDate() != null) {
		individual.setDeathDate(individualDetails.getDeathDate());
		}
		if (individualDetails.getCountryOfBirth() != null) {
		individual.setFamilyName(individualDetails.getCountryOfBirth());
		}
		if (individualDetails.getFullName() != null) {
		individual.setFullName(individualDetails.getFullName());
		}
		if (individualDetails.getGender() != null) {
		individual.setGender(individualDetails.getGender());
		}
		if (individualDetails.getBaseType() != null) {
		individual.setBaseType(individualDetails.getBaseType());
		}
		if (individualDetails.getSchemaLocation() != null) {
		individual.setSchemaLocation(individualDetails.getSchemaLocation());
		}
		if (individualDetails.getType() != null) {
		individual.setType(individualDetails.getType());
		}
		
		return individual;
	}

}

