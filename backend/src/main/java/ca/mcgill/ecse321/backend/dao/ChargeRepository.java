package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;



public interface ChargeRepository extends CrudRepository<Charge, Integer> {
	Charge findChargeByChargeId(int id);
	void deleteAll();
	Iterable<Charge> findAll();
}
