/*package ca.mcgill.ecse321.backend.tests;

import static org.junit.Assert.*;

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
import ca.mcgill.ecse321.backend.dao.EvaluationRepository;
import ca.mcgill.ecse321.backend.service.BackendService;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import ca.mcgill.ecse321.backend.dao.*;

import java.lang.Math;


public class EvaluationTests {
	@Mock
	private EvaluationRepository evaluationDao;

	@InjectMocks
	private BackendService service;

    @Test  
    public void testCreateEvaluation() {
        assertEquals(0, service.getAllEvaluations().size());
		Evaluation evaluation;

		int id = anyInt();
		Tutor tutor = new Tutor();
		tutor.setUserId(anyInt());
		tutor.setUserName(anyString());
		tutor.setPassword(anyString());
		Student student = new Student();
		student.setUserId(anyInt());
		student.setUserName(anyString());
		student.setPassword(anyString());
		boolean isFlagged = anyBoolean();
		String litEval = anyString();
		int numEval = anyInt();
		User user = new User();
		user.setUserId(anyInt());
		user.setUserName(anyString());
		user.setPassword(anyPassword());


		try {
			service.createEvaluation(id, tutor, student, isFlagged, litEval, numEval, user);
		} catch(IllegalArgumentException e) {
			// Check that no error occured
			fail();
		}
	    
	    	evaluation = service.getAllEvaluations().get(0);

		assertEquals(id, evaluation.getEvalId());
		assertEquals(tutor, evaluation.getTutor());
		assertEquals(student, evaluation.getStudent());
		assertEquals(isFlagged, evaluation.getIsFlagged());
		asswerEquals(litEval, evaluation.getLitEval());
  		assertEquals(numEval, evaluation.getNumEval());
		asswerEquals(user, evaluation.getSender());
    }
}*/
