package za.co.rain.spring;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import za.co.rain.spring.model.Register;
import za.co.rain.spring.model.Student;
import za.co.rain.spring.repository.RegisterRepository;
import za.co.rain.spring.repository.StudentRepository;
import za.co.rain.spring.security.model.ERole;
import za.co.rain.spring.security.model.Role;
import za.co.rain.spring.security.model.User;
import za.co.rain.spring.security.repo.RoleRepository;
import za.co.rain.spring.security.repo.UserRepository;

@Component 
public class MyRunner implements CommandLineRunner { 
	
	private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;

	@Override
	@Transactional
	public void run(String... strings) throws Exception { 
		
		logger.info("initializing Students...");
		
		studentRepository.save(new Student("Freddie", "Gwala", 7, "B", false));
		studentRepository.save(new Student("Sipho", "Mavuso", 10, "A", false));
		studentRepository.save(new Student("Mary", "Hlophe", 6, "D", false));
		studentRepository.save(new Student("Lorna", "Masuku", 8, "C", false));
		studentRepository.save(new Student("John", "Smith", 9, "E", false));
		studentRepository.save(new Student("Peter", "Gates", 12, "C", false));
		studentRepository.save(new Student("Portia", "Jackson", 11, "F", false));
		logger.info("Done initializing Students...");
		
		logger.info("initializing Registers...");
		
		
		List<Register> registers = new ArrayList<Register>();
		
		registers.add(new Register(11l, "Tommy", LocalDateTime.now().toLocalTime(), LocalDateTime.now().toLocalDate(), 2, "B", 7, true,7l,5l));
		registers.add(new Register(22l, "Fred", LocalDateTime.now().toLocalTime(), LocalDateTime.now().toLocalDate(), 1, "C", 8, false,7l,4l));
		registers.add(new Register(33l, "Mary", LocalDateTime.now().toLocalTime(), LocalDateTime.now().toLocalDate(), 3, "D", 10, true,4l,6l));
		registers.add(new Register(12l, "Dennis", LocalDateTime.now().toLocalTime(), LocalDateTime.now().toLocalDate(), 2, "B", 7, true,7l,5l));
		registers.add(new Register(15l, "Peter", LocalDateTime.now().toLocalTime(), LocalDateTime.now().toLocalDate(), 2, "B", 6, true,7l,5l));
		registerRepository.saveAll(registers);
		
		logger.info("Done initializing Registers...");
		List<Register> list = registerRepository.findByTerm(2);
		
		logger.info("findByTerm Registers..."+ list.size());
		
		logger.info("initializing Roles...");
		
		roleRepository.save(new Role(ERole.ROLE_USER));
		roleRepository.save(new Role(ERole.ROLE_ADMIN));
		
		logger.info("Done initializing Roles...");
		
		logger.info("initializing Users...");
		
		User user1 = new User("tester", 
				"tester@tester.com",
				encoder.encode("tester"));
		User user2 = new User("analyst", 
				"analyst@analyst.com",
				encoder.encode("analyst"));
		User user3 = new User("admini", 
				"admini@admini.com",
				encoder.encode("admini"));
		Set<Role> roleUser = new HashSet<Role>();
		Set<Role> roleAdmin = new HashSet<Role>();
		roleUser.add(new Role(ERole.ROLE_USER));
		roleAdmin.add(new Role(ERole.ROLE_USER));
		roleAdmin.add(new Role(ERole.ROLE_ADMIN));
		
		user1.setRoles(roleUser);
		user2.setRoles(roleUser);
		user3.setRoles(roleUser);
		user3.setRoles(roleAdmin);
		
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		logger.info("Done initializing Users...");
		
	}
}
