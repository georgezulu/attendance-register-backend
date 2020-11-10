package za.co.rain.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	private String name;
	private String surname;
	private int grade;
	private String clas;
	private boolean present;

	public Student() {
	};

	public Student(String name, String surname, int grade, String clas, boolean present) {
		
		if (name == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Name and Surname can't be null");
        }
		this.name = name;
		this.surname = surname;
		this.grade = grade;
		this.clas = clas;
		this.present = present;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getClas() {
		return clas;
	}

	public void setClas(String clas) {
		this.clas = clas;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}
}
