package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;



public interface CompanyRepository extends CrudRepository<Company, Integer> {
	Company findCompanyByCompanyId(int id);
	Iterable<Company> findAll();
	void deleteAll();
}
