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
import ca.mcgill.ecse321.backend.dao.CourseRepository;
import ca.mcgill.ecse321.backend.dao.SchoolRepository;
import ca.mcgill.ecse321.backend.dao.SubjectRepository;
import ca.mcgill.ecse321.backend.service.BackendService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTests {

	@Autowired
	private BackendService service;

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SchoolRepository schoolRepository;


//	@Before
//	public void create() {
//		courseRepository.deleteAll();
//		service.createSubject(324329, "ECSE");
//		SchoolType mySchool = SchoolType.University;
//		service.createSchool(324320, "McGill", mySchool);
//	}

	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		courseRepository.deleteAll();
		subjectRepository.deleteAll();
		schoolRepository.deleteAll();
	}

//	@Test
//	public void testCreateCourse() {
//		assertEquals(0, service.getAllCourses().size());
//		
//		service.createSubject(324329, "ECSE");
//		SchoolType mySchool = SchoolType.University;
//		service.createSchool(1345, "McGill", mySchool);
//
//		String name = "ECSE 321";
//
//		try {
//			service.createCourse(324325, name, 1345, 324329);
//		} catch (IllegalArgumentException e) {
//			// Check that no error occurred
//			fail();
//		}
//
//		List<Course> allCourse = service.getAllCourses();
//
//		assertEquals(1, allCourse.size());
//		assertEquals(name, allCourse.get(0).getName());
//	}

	@Test
	public void testCreateCoursesNull() {
		service.createSubject(3243, "ECSE");
		SchoolType mySchool = SchoolType.University;
		service.createSchool(3244, "McGill", mySchool);
		
		assertEquals(0, service.getAllCourses().size());

		String name = null;
		int id = 3213342;
		String error = null;

		try {
			service.createCourse(3213342, name, 3244, 3243);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Course name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllCourses().size());
	}

//	@Test
//	public void testCreateCourseIdAlreadyExists() {
//		service.createSubject(324, "ECSE");
//		SchoolType mySchool = SchoolType.University;
//		service.createSchool(32, "McGill", mySchool);
//		
//		assertEquals(0, service.getAllCourses().size());
//
//		int id = 3213342;
//		String error = null;
//
//		try {
//			service.createCourse(id, "ECSE 321", 32, 324);
//			service.createCourse(id, "ECSE 324", 32, 324);
//		} catch (IllegalArgumentException e) {
//			error = e.getMessage();
//		}
//
//		// check error
//		assertEquals("Course ID already exists", error);
//
//		// only one object added to memory
//		assertEquals(1, service.getAllCourses().size());
//	}


}