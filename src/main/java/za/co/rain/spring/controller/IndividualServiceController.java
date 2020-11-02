package za.co.rain.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.rain.spring.exception.ResourceNotFoundException;
import za.co.rain.spring.model.Individual;
import za.co.rain.spring.repository.IndividualRepository;
import za.co.rain.spring.utils.ApiUtililities;

@RestController
public class IndividualServiceController {
	
   private static final Logger logger = LoggerFactory.getLogger(IndividualServiceController.class);
   
   @Autowired
   private IndividualRepository individualRepository;
   
   @DeleteMapping(value = "/individual/{id}")
   public Map <String, Boolean> deleteIndividual(@PathVariable("id") Long id) throws ResourceNotFoundException { 
	   
	   Individual individual = individualRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Individual not found for this id :: " + id));
	   
     individualRepository.delete(individual);
     Map < String, Boolean > response = new HashMap <> ();
     response.put("deleted", Boolean.TRUE);
     return response;
   }
   
   @PutMapping(value = "/individual/{id}")
   public ResponseEntity<Individual> patchIndividual(@PathVariable("id") Long id, @Valid @RequestBody Individual individualDetails) throws ResourceNotFoundException  { 
	   
	   Individual individual = individualRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Individual not found for this id :: " + id));
	   
	   individual = ApiUtililities.setNewValues(individual, individualDetails);
	   
      individualRepository.save(individual);
      final Individual patchedIndividual = individualRepository.save(individual);
      return ResponseEntity.ok(patchedIndividual);
   }
   
   @PostMapping(value = "/individual")
   public Individual createIndividual(@Valid @RequestBody Individual individual) {
	   
      return individualRepository.save(individual);
   }
   
   @GetMapping(value = "/individual")
   public List<Individual> listIndividual() {
	   
	   logger.info("Fetching Individuals...");
	   logger.info("Number of Individuals fetched > " + individualRepository.count());
	   
	  return   individualRepository.findAll();
    }
   
   @GetMapping(value = "/individual/{id}")
   public ResponseEntity <Individual> retrieveIndividual(@PathVariable(value = "id") Long id)
		    throws ResourceNotFoundException {
   
	   Individual individual = individualRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Individual not found for this id :: " + id));
	   
	   return ResponseEntity.ok().body(individual);
   }
}