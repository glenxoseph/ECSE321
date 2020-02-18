/*package ca.mcgill.ecse321.backend.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.backend.jpa.*;
import ca.mcgill.ecse321.backend.dao.BackendRepository;
import ca.mcgill.ecse321.backend.dao.StudentRepository;
import ca.mcgill.ecse321.backend.dao.SchoolRepository;
import ca.mcgill.ecse321.backend.service.BackendService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTests {

	@Autowired
	private BackendService service;

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private SchoolRepository schoolRepository;
	
	
	

	@Test
	public void testCreateStudent() {
		assertEquals(0, service.getAllUsers().size());

		String name = "Franck";
		int id=260787802;
		String passWord="abcd";
		SchoolType mySchoolType= SchoolType.University;
		service.createSchool(324321, "McGill", mySchoolType);
		School mySchool= schoolRepository.findSchoolByschoolId(324321);
		
        
		try {
			service.createStudent(id, name, passWord, mySchool);
		
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<User> allStudent = service.getAllUsers();

		assertEquals(1, allStudent.size());
		assertEquals(name, allStudent.get(0).getUserName());
	}
	
	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		studentRepository.deleteAll();
		schoolRepository.deleteAll();
		

	}


	@Test
	public void testCreateStudentNull() {
		assertEquals(0, service.getAllUsers().size());

		String name = null;
		int id = 260787802;
		String error = null;
		String passWord="abcd";
		SchoolType mySchoolType= SchoolType.University;
		service.createSchool(324321, "McGill", mySchoolType);
		School mySchool= schoolRepository.findSchoolByschoolId(324321);

		try {
			service.createStudent(id, name, passWord, mySchool);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("String name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllUsers().size());
	}
	
	@Test
	public void testCreateStudentdAlreadyExists() {
		assertEquals(0, service.getAllUsers().size());

		
		String error = null;
		String name1 = "Franck";
		String name2 = "Glen";
		int id=260787802;
		String passWord="abcd";
		SchoolType mySchoolType= SchoolType.University;
		service.createSchool(324321, "McGill", mySchoolType);
		School mySchool= schoolRepository.findSchoolByschoolId(324321);
		

		try {
			service.createStudent(id, name1, passWord,mySchool);
			service.createStudent(id, name2, passWord,mySchool);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Student ID already exists", error);

		// only one object added to memory
		assertEquals(1, service.getAllUsers().size());
	}
	

}*/
