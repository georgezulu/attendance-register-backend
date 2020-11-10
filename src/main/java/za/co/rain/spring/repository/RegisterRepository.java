package za.co.rain.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import za.co.rain.spring.model.Register;

@Repository
public interface RegisterRepository extends CrudRepository< Register, Long> {
	
 	//@Transactional
	//public List<Register> saveAllIn(List<Register> registers);
	 //@Query("SELECT e from Register e where e.studentName =?1 ")       
	List<Register> findByDate(Date date);
	@Query("select new za.co.rain.spring.model.Register(r.studentId, r.studentName, r.time, r.date, r.term, r.className, r.grade, r.present, count(case when r.present = true THEN 1 END), count(case when r.present = false THEN 1 END)) from Register r where r.term =?1 group by r.studentId, r.time")
	List<Register> findByTerm(int term);
}