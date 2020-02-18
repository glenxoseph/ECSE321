package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;



public interface StudentRepository extends CrudRepository<Student, Integer> {
	Student findStudentByUserId(int id);
	void deleteAll();
	Iterable<Student> findAll();
}
