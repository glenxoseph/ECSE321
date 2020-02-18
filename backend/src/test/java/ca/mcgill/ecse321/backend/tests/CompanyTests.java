package ca.mcgill.ecse321.backend.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.backend.dao.CompanyRepository;
import ca.mcgill.ecse321.backend.dao.SubjectRepository;
import ca.mcgill.ecse321.backend.jpa.Company;
import ca.mcgill.ecse321.backend.jpa.Subject;
import ca.mcgill.ecse321.backend.service.BackendService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyTests {

	@Autowired
	private BackendService service;
	
	@Autowired
	private CompanyRepository CompanyRepo;

	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		CompanyRepo.deleteAll();

	}

//	@Test
//	public void testCreateCompanyNameNull() {
//		assertEquals(0, service.getAllCompanies().size());
//
//		String name = null;
//		String error = null;
//		
//		try {
//			service.createCompany(231, name, 7, 18);
//		} catch (IllegalArgumentException e) {
//			// Check that no error occurred
//			error = e.getMessage();
//		}
//		// check error
//		assertEquals("Company name cannot be empty!", error);
//	
//		// check no change in memory
//		assertEquals(0, service.getAllCompanies().size());
//	}
//	
//	@Test
//	public void testCreateCompany() {
//		assertEquals(0, service.getAllCompanies().size());
//
//		String name = "18 Inc.";
//		
//		try {
//			service.createCompany(231, name, 7, 18);
//		} catch (IllegalArgumentException e) {
//			// Check that no error occurred
//			fail();
//		}
//
//		List<Company> allCompanies = service.getAllCompanies();
//
//		assertEquals(1, allCompanies.size());
//		assertEquals(name, allCompanies.get(0).getName());
//
//	}
	@Test //needs to be done when user and room are fully creatable
	public void testAddUser() {

	}
	@Test
	public void testAddRoom() {

	}
	

}
