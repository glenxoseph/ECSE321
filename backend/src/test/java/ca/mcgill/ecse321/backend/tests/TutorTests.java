/*package ca.mcgill.ecse321.backend.tests;

import static org.junit.Assert.*;
import java.util.List;

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
import ca.mcgill.ecse321.backend.dao.CompanyRepository;
import ca.mcgill.ecse321.backend.dao.TutorRepository;
import ca.mcgill.ecse321.backend.service.BackendService;
import static org.mockito.ArgumentMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorTests {	
	@Autowired
	private TutorRepository tutorDao;
	
	@Autowired
	private CompanyRepository companyDao;
	
	@Autowired
	private SubjectRepository subjectDao;

	@Autowired
	private BackendService service;
	
	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		tutorDao.deleteAll();
	}

    @Test  
    public void testCreateTutor() {
        assertEquals(0, service.getAllTutors().size());
		Tutor tutor;

		int id = 123;
		String username = "Oscar";
		String password = "123456";
		service.createCompany(321, "myCompany", 7, 9);
		service.createSubject(98, "mySubject");
		Company company = companyDao.findCompanyByCompanyId(321);
		Subject subject = subjectDao.findSubjectBysubjectId(98);

		try {
			service.createTutor(id, username, password, company, subject);
		} catch(IllegalArgumentException e) {
			// Check that no error occured
			fail();
		}

		//assertEquals(username, tutor.getUserName());
		//assertEquals(password, tutor.getPassword());
		//assertEquals(id, tutor.getUserId());
		//assertEquals(company, tutor.getCompany());
		//assertEquals(subject, tutor.getSubject());
    }
	/*
    @Test  
    public void testCreateTutorNull() {
		String error = null;
		Tutor tutor;

		int id = 123;
		String username = "Oscar";
		String password = "123456";
		Company company = new Company();
		company.setName(anyString());
		company.setCompanyId(anyInt());
		Subject subject = new Subject();
		subject.setSubjectId(anyInt());
		subject.setName(anyString());

		try {
			tutor = service.createTutor(null, username, password, company, subject);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
			
		}

		// check error
		assertEquals("Tutor id cannot be empty!", error);

		try {
			tutor = service.createTutor(id, null, password, company, subject);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
			
		}

		// check error
		assertEquals("Tutor userName cannot be empty!", error);

		try {
			tutor = service.createTutor(id, username, null, company, subject);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
			
		}

		// check error
		assertEquals("Tutor password cannot be empty!", error);

		try {
			tutor = service.createTutor(id, username, password, null, subject);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
			
		}

		// check error
		assertEquals("Tutor company cannot be empty!", error);

		try {
			tutor = service.createTutor(id, username, password, company, null);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
			
		}

		// check error
		assertEquals("Tutor subject cannot be empty!", error);
    }

	@Test  
    public void testWarnTutor() {
		Tutor tutor;
		String error = null;

		Company company = new Company();
		company.setName(anyString());
		company.setCompanyId(anyInt());
		Subject subject = new Subject();
		subject.setSubjectId(anyInt());
		subject.setName(anyString());

		int warning = anyInt();

		try {
			tutor = service.createTutor(anyInt(), anyString(), anyString(), company, subject);
			service.warnTutor(warning);
		} catch(IllegalArgumentException e) {
			// Check that no error occured
			fail();
		}

		assertEquals(true, tutor.getWarnings().contains(warning));
		assertEquals(1, tutor.getNumWarnings());

		try {
			tutor = service.createTutor(anyInt(), anyString(), anyString(), company, subject);
			service.warnTutor(null);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals(false, e.getMessage == null);
    }

	@Test  
    public void testSuspendTutor() {
		Tutor tutor;
		String error = null;

		Company company = new Company();
		company.setName(anyString());
		company.setCompanyId(anyInt());
		Subject subject = new Subject();
		subject.setSubjectId(anyInt());
		subject.setName(anyString());

		int days = Math.abs(anyInt());

		try {
			tutor = service.createTutor(anyInt(), anyString(), anyString(), company, subject);
			service.suspendTutor(days, tutor.getId());
		} catch(IllegalArgumentException e) {
			// Check that no error occured
			fail();
		}

		assertEquals(true, tutor.getSuspended());
		assertEquals(days, tutor.getDaysLeftSuspended());

		
		try {
			tutor = service.createTutor(anyInt(), anyString(), anyString(), company, subject);
			service.suspendTutor(null, tutor.getId());
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals(false, error == null);

		error = null;
		try {
			tutor = service.createTutor(anyInt(), anyString(), anyString(), company, subject);
			service.suspendTutor(null, tutor.getId());
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals(false, error == null);

    }

	@Test  
    public void testFireTutor() {
		Tutor tutor;
		String error = null;

		Company company = new Company();
		company.setName(anyString());
		company.setCompanyId(anyInt());
		Subject subject = new Subject();
		subject.setSubjectId(anyInt());
		subject.setName(anyString());

		int warning = anyInt();

		try {
			tutor = service.createTutor(anyInt(), anyString(), anyString(), company, subject);
			service.fireTutor(tutor.getId());
		} catch(IllegalArgumentException e) {
			// Check that no error occured
			fail();
		}

		assertEquals(true, tutor.isFired());

		try {
			tutor = service.createTutor(anyInt(), anyString(), anyString(), company, subject);
			service.fire(null);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}

		assertEquals(false, e.getMessage == null);
    }
	
}*/
