package ca.mcgill.ecse321.backend.tests;

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
import ca.mcgill.ecse321.backend.dao.SchoolRepository;
import ca.mcgill.ecse321.backend.dao.SubjectRepository;
import ca.mcgill.ecse321.backend.service.BackendService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SchoolTests {

	@Autowired
	private BackendService service;

	@Autowired
	private SchoolRepository schoolRepository;

	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		schoolRepository.deleteAll();

	}

	@Test
	public void testCreateSchool() {
		assertEquals(0, service.getAllSchools().size());

		String name = "McGill";
		SchoolType mySchool = SchoolType.University;

		try {
			service.createSchool(1345, name, mySchool);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<School> allSchool = service.getAllSchools();

		assertEquals(1, allSchool.size());
		assertEquals(name, allSchool.get(0).getName());
	}

	@Test
	public void testCreateSchoolNull() {
		assertEquals(0, service.getAllSchools().size());

		String name = null;
		int id = 3213342;
		String error = null;

		SchoolType mySchool = SchoolType.University;

		try {
			service.createSchool(3213342, name, mySchool);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("School name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllSchools().size());
	}
	
	@Test
	public void testCreateSchoolIdAlreadyExists() {
		assertEquals(0, service.getAllSchools().size());

		int id = 3213342;
		String error = null;
		
		SchoolType mySchool = SchoolType.University;

		try {
			service.createSchool(id, "Math", mySchool);
			service.createSchool(id, "Science", mySchool);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("School ID already exists", error);

		// only one object added to memory
		assertEquals(1, service.getAllSchools().size());
	}
	

}
