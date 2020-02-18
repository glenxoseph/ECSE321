/*package ca.mcgill.ecse321.backend.tests;

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
import ca.mcgill.ecse321.backend.dao.RoomRepository;
import ca.mcgill.ecse321.backend.dao.CompanyRepository;
import ca.mcgill.ecse321.backend.service.BackendService;
import static org.mockito.ArgumentMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomTests {
	@Autowired
	private BackendService service;
	@Autowired
	private RoomRepository roomRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		companyRepository.deleteAll();
	}
	
	@Test
	public void testCreateRoom() {
		assertEquals(0, service.getAllRooms().size());
		
		int id = 123;
		boolean ifFree = false;
		int capacity = 8;
		service.createCompany(321, "myCompany", 3, 8);
		Company company = companyRepository.findCompanyByCompanyId(321);
		
		try {
			service.createRoom(id, ifFree, capacity, company);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}
		//assertEquals(1, service.getAllRooms().size());
		List<Room> rooms = service.getAllRooms();
		//assertEquals(id, rooms.get(0).getRoomId());
		//assertEquals(ifFree, rooms.get(0).isIfFree());
		//assertEquals(capacity, rooms.get(0).getCapacity());
		//assertEquals(company, rooms.get(0).getCompany1());
	}
}*/