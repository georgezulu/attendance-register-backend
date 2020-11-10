package za.co.rain.spring.controller;

import java.time.LocalDateTime;
import java.time.temporal.IsoFields;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.rain.spring.model.Register;
import za.co.rain.spring.model.Student;
import za.co.rain.spring.security.jwt.JwtUtils;
import za.co.rain.spring.security.payload.request.LoginRequest;
import za.co.rain.spring.security.payload.response.JwtResponse;
import za.co.rain.spring.security.repo.RoleRepository;
import za.co.rain.spring.security.repo.UserRepository;
import za.co.rain.spring.security.services.UserDetailsImpl;
import za.co.rain.spring.service.RegisterService;
import za.co.rain.spring.utils.ApiUtililities;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api")
public class RegisterController {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository; 

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@RequestMapping(value = "/saveall", method = RequestMethod.POST)
	@ResponseBody
	public List<Register> saveAllRegisters(@RequestBody List<Student> students) {
		
		List<Register> registerList = ApiUtililities.buildRegisters(students);
		List<Register> registerResponse = (List<Register>) registerService.saveAllRegisters(registerList);
		return registerResponse;
	}
	
	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@ResponseBody
	public List<Register> getAllRegisters() {
		List<Register> registerResponse = (List<Register>) registerService.getAllRegisters();
		System.out.println("**************** IN the getAllRegisters");
		return registerResponse;
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Register saveRegister(@RequestBody Register register) {
		Register registerResponse = registerService.saveRegister(register);
		return registerResponse;
	}
	@RequestMapping(value = "/saveallS", method = RequestMethod.POST)
	@ResponseBody
	public List<Register> saveAllStudents(@RequestBody List<Student> students) {
		
		//List<Register> registerList = ApiUtililities.buildRegisters(students);
		System.out.println("**************** IN the saveAllStudents");
		List<Register> registerList = ApiUtililities.buildRegisters(students);
		List<Register> registerResponse = (List<Register>) registerService.saveAllRegisters(registerList);
		return registerResponse;
		//List<Student> studentResponse = (List<Student>) registerService.saveAllSudents(students);
		//return studentResponse;
	}
	@RequestMapping(value = "/getByDate", method = RequestMethod.GET)
	@ResponseBody
	public List<Register> getRegisterByDate(@RequestBody Date date) {
		List<Register> registerResponse = (List<Register>) registerService.findByDate(date);
		return registerResponse;
	}
	@RequestMapping(value = "/getByTerm", method = RequestMethod.GET)
	@ResponseBody
	public List<Register> findByTerm() {
		
		int t = LocalDateTime.now().get(IsoFields.QUARTER_OF_YEAR);
		System.out.println("**************** IN the findByTerm");
		List<Register> registerResponse = (List<Register>) registerService.findByTerm(t);
		System.out.println("**************** IN the findByTerm response "+ registerResponse.size());
		return registerResponse;
	}

	 @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/signin") 
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}
}

