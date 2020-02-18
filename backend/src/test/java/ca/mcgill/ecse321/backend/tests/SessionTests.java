/*package ca.mcgill.ecse321.backend.tests;

import static org.junit.Assert.*;

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
import ca.mcgill.ecse321.backend.dao.SessionRepository;
import ca.mcgill.ecse321.backend.service.BackendService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ca.mcgill.ecse321.backend.dao.*;

import java.lang.Math;


public class SessionTests {
	Needs to be tested
	
	@Mock
	private SessionRepository SessionDao;

	@InjectMocks
	private BackendService service;

    @Test  
    public void testCreateSession() {
        assertEquals(0, service.getAllSessions().size());
		Session session;

		int id = anyInt();
		int startTime = anyInt();
		int endTime = anyInt();
		Charge charge = new Charge();
		Course course = new Course();
		Tutor tutor = new Tutor();

		try {
			service.createSession(id, startTime, endTime, charge, course, tutor);
		} catch(IllegalArgumentException e) {
			// Check that no error occured
			fail();
		}
	    
	    	session = service.getAllSessions.get(0);

		assertEquals(id, session.getSessionId()));
		assertEquals(startTime, session.getStartTime());
		assertEquals(endTime, session.getEndTime());
		assertEquals(charge, session.getCharge());
		assertEquals(course, session.getCourse());
		assertEquals(tutor, session.getTutor());
    }
}*/
