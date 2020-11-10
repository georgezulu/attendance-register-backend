package za.co.rain.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import za.co.rain.spring.model.Register;
import za.co.rain.spring.model.Student;

@Component
public interface RegisterService {
	public List<Register> saveAllRegisters(List<Register> registerList);
	public List<Register> getAllRegisters();
	public Register saveRegister(Register register);
	public List<Student> saveAllSudents(List<Student> students);
	public List<Register> findByDate(Date date);
	public List<Register> findByTerm(int term);
	
}
