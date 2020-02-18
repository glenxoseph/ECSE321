package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;


public interface SubjectRepository extends CrudRepository<Subject, Integer> {

	Subject findSubjectBysubjectId(int subjectID);
	void deleteAll();
	Iterable<Subject> findAll();
	
}
