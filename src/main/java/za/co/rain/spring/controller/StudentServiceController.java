package za.co.rain.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import za.co.rain.spring.exception.ResourceNotFoundException;
import za.co.rain.spring.model.Student;
import za.co.rain.spring.repository.StudentRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class StudentServiceController {
	
   private static final Logger logger = LoggerFactory.getLogger(StudentServiceController.class);
   
   @Autowired
   private StudentRepository studentRepository;
   
   @PostMapping(value = "/student")
   public Student createStudent(@Valid @RequestBody Student student) {
	   
      return studentRepository.save(student);
   }
   
   @GetMapping(value = "/student")
   public List<Student> listStudent() {
	   
	   logger.info("Fetching Students...");
	   logger.info("Number of Students fetched > " + studentRepository.count());
	   
	  return   studentRepository.findAll();
    }
   @GetMapping(value = "/student/{id}")
   public ResponseEntity <Student> getStudentById(@PathVariable(value = "id") Long id)
		    throws ResourceNotFoundException {
   
	   Student student = studentRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
	   
	   return ResponseEntity.ok().body(student);
   }
   @CrossOrigin(origins = "http://localhost:4200")
   @PutMapping(value = "/student/{id}")
   public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @Valid @RequestBody Student studentDetails) throws ResourceNotFoundException  { 
	   
	   Student student = studentRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
	   
	   student.setName(studentDetails.getClas());
	   student.setSurname(studentDetails.getSurname());
	   student.setClas(studentDetails.getClas());
	   student.setGrade(studentDetails.getGrade());
	   student.setPresent(studentDetails.isPresent());
	   
	   Student updatedStudent = studentRepository.save(student);
	   return ResponseEntity.ok(updatedStudent);
   } 	 
   @CrossOrigin(origins = "http://localhost:4200")
   @DeleteMapping(value = "/student/{id}")
   public Map <String, Boolean> deleteStudent(@PathVariable("id") Long id) throws ResourceNotFoundException { 
	   
	   Student student = studentRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found for this id :: " + id));
	   
	   studentRepository.delete(student);
     Map < String, Boolean > response = new HashMap <> ();
     response.put("deleted", Boolean.TRUE);
     return response;
   }
   @CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/student/getByClass/{clas}", method = RequestMethod.GET)
	@ResponseBody
	public List<Student> findByClass(@PathVariable("clas") String clas) throws ResourceNotFoundException {
		
		System.out.println("**************** IN the findByClass");
		List<Student> studentResponse =  studentRepository.findByClas(clas);
		System.out.println("**************** IN the findByClass response "+ studentResponse.size());
		return studentResponse;
	}
}