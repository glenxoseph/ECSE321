/*package ca.mcgill.ecse321.backend.tests;

import java.util.List;

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
import ca.mcgill.ecse321.backend.dao.ChargeRepository;
import ca.mcgill.ecse321.backend.service.BackendService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ca.mcgill.ecse321.backend.dao.*;

import java.lang.Math;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChargeTests {
	@Autowired
	private ChargeRepository chargeDao;

	@Autowired
	private BackendService service;
	
	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		chargeDao.deleteAll();
	}

    @Test  
    public void testCreateCharge() {
        assertEquals(0, service.getAllCharges().size());
		int id = anyInt();
		Session session = new Session();
		session.setSessionId(anyInt());
		int value = anyInt();

		try {
			service.createCharge(id, session, value);
		} catch(IllegalArgumentException e) {
			// Check that no error occured
			fail();
		}
	    	
	    	//assertEquals(1, service.getAllCharges().size());
	    	List<Charge> charges = service.getAllCharges();

		//assertEquals(id, charges.get(0).getChargeId());
		//assertEquals(session, charges.get(0).getSession());
		//assertEquals(value, charges.get(0).getValue());
    }
}*/