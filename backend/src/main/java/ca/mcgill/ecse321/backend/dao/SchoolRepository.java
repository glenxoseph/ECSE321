package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;

public interface SchoolRepository extends CrudRepository<School, Integer> {
	School findSchoolByschoolId(int id);
	void deleteAll();
	Iterable<School> findAll();
}
