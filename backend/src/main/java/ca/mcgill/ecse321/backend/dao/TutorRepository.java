package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;

public interface TutorRepository extends CrudRepository<Tutor, Integer> {
	Tutor findTutorByUserId(int userId);
	void deleteAll();
	Iterable<Tutor> findAll();
}