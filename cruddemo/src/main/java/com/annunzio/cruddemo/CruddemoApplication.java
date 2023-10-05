package com.annunzio.cruddemo;

import com.annunzio.cruddemo.Entity.Student;
import com.annunzio.cruddemo.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//Executed after beans are loaded into app context
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			System.out.println("Hello World");
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAll(studentDAO);
		};

	}

	private void deleteAll(StudentDAO studentDAO) {
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Number of rows deleted = " + numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 5;
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		Student stud = studentDAO.findById(studentId);
		stud.setFirstName("Paul");
		stud.setLastName("Wall");
		stud.setEmail("paulWall@gmail.com");
		studentDAO.update(stud);
		System.out.println(stud);
	}

	private void queryByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Dummy");
		for (Student stud: students){
			System.out.println(stud);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for(Student stud: students){
			System.out.println(stud);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//Retrieve student based on ID
		Student mySearch = studentDAO.findById(2);
		//Print student
		System.out.println(mySearch);
	}

	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("------Creating student object-------");
		Student student = new Student("Devin", "Annunzio","Annunzio.devin@gmail.com");
		//save student object
		studentDAO.save(student);
		System.out.println("------Saving student object-------");
		//display id of student
		System.out.println("------Printing student object info-------");
		System.out.println(student);

	}
}
