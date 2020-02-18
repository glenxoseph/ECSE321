package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;



public interface UserRepository extends CrudRepository<User, Integer> {
	User findUserByuserId(int id);
	void deleteAll();
	Iterable<User> findAll();
}