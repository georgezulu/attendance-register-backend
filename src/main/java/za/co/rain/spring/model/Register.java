package za.co.rain.spring.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
//@Table(name="Register")
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long studentId;
	private String studentName;
	private LocalTime time;
	private LocalDate date;
	private int term;
	private String className;
	private int grade;
	private boolean present;
	@Transient
	private Long attendedClasses;
	@Transient
	private Long missedClasses;
	
	public Register(Long studentId, String studentName, LocalTime time, LocalDate date, int term, String className, int grade,
			boolean present, Long attendedClasses, Long missedClasses) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.time = time;
		this.date = date;
		this.term = term;
		this.className = className;
		this.grade = grade;
		this.present = present;
		this.attendedClasses = attendedClasses;
		this.missedClasses = missedClasses;
	}

	public Register() {
	}
	public Long getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getMissedClasses() {
		return missedClasses;
	}

	public void setMissedClasses(Long missedClasses) {
		this.missedClasses = missedClasses;
	}

	public Long getAttendedClasses() {
		return attendedClasses;
	}

	public void setAttendedClasses(Long attendedClasses) {
		this.attendedClasses = attendedClasses;
	}

}