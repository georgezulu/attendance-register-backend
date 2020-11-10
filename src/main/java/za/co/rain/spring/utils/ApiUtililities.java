package za.co.rain.spring.utils;

import java.time.LocalDateTime;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.List;

import za.co.rain.spring.model.Register;
import za.co.rain.spring.model.Student;

public class ApiUtililities {
	

	public static List<Register> buildRegisters(List<Student> students) {

		List<Register> registers = new ArrayList<Register>();
		for (Student s : students) {
			
			registers.add(new Register(s.getId(), s.getName()+" "+s.getSurname(), LocalDateTime.now().toLocalTime(),
					LocalDateTime.now().toLocalDate(), LocalDateTime.now().get(IsoFields.QUARTER_OF_YEAR), s.getClas(), s.getGrade(), s.isPresent(),0l,0l));
		}
			return registers;
		}

}

