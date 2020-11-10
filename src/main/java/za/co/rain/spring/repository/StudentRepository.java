package za.co.rain.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.rain.spring.model.Register;
import za.co.rain.spring.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
	public List<Student> findByClas(String clas);
}