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
import ca.mcgill.ecse321.backend.dao.SubjectRepository;
import ca.mcgill.ecse321.backend.service.BackendService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SubjectTests {

	@Autowired
	private BackendService service;

	@Autowired
	private SubjectRepository subjectRepository;


	@Test
	public void testCreateSubject() {
		assertEquals(0, service.getAllSubjects().size());

		String name = "Math";

		try {
			service.createSubject(324324, name);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Subject> allSubject = service.getAllSubjects();

		assertEquals(1, allSubject.size());
		assertEquals(name, allSubject.get(0).getName());
	}

	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		subjectRepository.deleteAll();

	}
	
	@Test
	public void testCreateSubjectNull() {
		assertEquals(0, service.getAllSubjects().size());

		String name = null;
		int id = 3213342;
		String error = null;

		try {
			service.createSubject(3213342, name);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Subject name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllSubjects().size());
	}
	

	
	@Test
	public void testCreateSubjectIdAlreadyExists() {
		assertEquals(0, service.getAllSubjects().size());

		int id = 3213342;
		String error = null;

		try {
			service.createSubject(id, "Math");
			service.createSubject(id, "Science");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Subject ID already exists", error);

		// only one object added to memory
		assertEquals(1, service.getAllSubjects().size());
	}
	

}
