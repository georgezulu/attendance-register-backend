package za.co.rain.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.rain.spring.model.Register;
import za.co.rain.spring.repository.RegisterRepository;

@RestController
public class RegisterServiceController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterServiceController.class);

	@Autowired
	private RegisterRepository registerRepository;

	@PostMapping(value = "/register")
	public Register saveRegister(@Valid @RequestBody Register register) {

		return registerRepository.save(register);
	}

	
	//@PostMapping(value = "/register")
	//@Transactional
	//public List<Register> saveAllRegisters(@Valid @RequestBody List<Register> registers) {

		//return (List<Register>) registerRepository.saveAllIn(registers);
		
	//}
	

	@GetMapping(value = "/register")
	public List<Register> findAllRegister() {

		logger.info("Fetching Individuals...");
		logger.info("Number of Individuals fetched > " + registerRepository.count());

		return (List<Register>) registerRepository.findAll();
	}

}