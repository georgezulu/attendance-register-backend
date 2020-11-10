package za.co.rain.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import za.co.rain.spring.model.Register;
import za.co.rain.spring.model.Student;
import za.co.rain.spring.repository.RegisterRepository;
import za.co.rain.spring.repository.StudentRepository;

@Service("registerServiceImpl")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private RegisterRepository registerRepository;
	
	@Autowired
	private StudentRepository studentRepository;


	@Transactional
	public List<Register> saveAllRegisters(List<Register> registerList) {
		List<Register> response = (List<Register>) registerRepository.saveAll(registerList);
		return response;
	}
	
	@Transactional
	public List<Register> getAllRegisters() {
		List<Register> registerResponse = (List<Register>) registerRepository.findAll();
		return registerResponse;
	}
	
	public Register saveRegister(Register register) {
		Register saveResponse = (Register) registerRepository.save(register);
		return saveResponse;
	}
	public List<Student> saveAllSudents(List<Student> students) {
		
		List<Student> response = (List<Student>) studentRepository.saveAll(students);
		return response;
	}
	public List<Register> findByDate(Date date) {
		List<Register> registerResponse = (List<Register>) registerRepository.findByDate(date);
		return registerResponse;
		
	}
	public List<Register> findByTerm(int term) {
		List<Register> registerResponse = (List<Register>) registerRepository.findByTerm(term);
		return registerResponse;
		
	}
}

