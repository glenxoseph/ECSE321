package ca.mcgill.ecse321.backend.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.backend.jpa.*;



public interface EvaluationRepository extends CrudRepository<Evaluation, Integer> {
	Evaluation findEvaluationByEvalId(int id);
	void deleteAll();
	Iterable<Evaluation> findAll();
}
