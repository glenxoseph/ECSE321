package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;



public interface CourseRepository extends CrudRepository<Course, Integer> {
	Course findCourseByCourseId(int id);
	void deleteAll();
	Iterable<Course> findAll();
}
