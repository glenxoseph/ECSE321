package ca.mcgill.ecse321.backend.dao;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



import ca.mcgill.ecse321.backend.jpa.*;


@Repository
public class BackendRepository {
	@Autowired
	EntityManager entityManager;
	
	// Session
	
	public Session createSession(int aId, int startTime, int endTime, Charge aCharge, Course aCourse, Tutor aTutor) {
		if (startTime >= endTime) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		
		Session session = new Session();
		session.setSessionId(aId);
		session.setStartTime(startTime);
		session.setEndTime(endTime);
		session.setCharge(aCharge);
		session.setCourse(aCourse);
		session.setTutor(aTutor);
		
		entityManager.persist(session);
		return session;
	}
	
	@Transactional
	public Session getSession(String aId) {
		Session aSession = entityManager.find(Session.class, aId);
		return aSession;
	}
	
	// Evaluation
	
	public Evaluation createEvaluation(int aId, Tutor tutor, Student student, boolean isFlagged, String litEval, int numEval, User aSender) {
		
		Evaluation evaluation = new Evaluation();
		evaluation.setEvalId(aId);
		evaluation.setTutor(tutor);
		evaluation.setStudent(student);
		evaluation.setIsFlagged(isFlagged);
		evaluation.setLitEval(litEval);
		evaluation.setNumEval(numEval);
		evaluation.setSender(aSender);
		
		entityManager.persist(evaluation);
		return evaluation;
	}
	
	@Transactional
	public Evaluation getEvaluation(String aId) {
		Evaluation aEvaluation = entityManager.find(Evaluation.class, aId);
		return aEvaluation;
	}
	
	// Room
	
	@Transactional
	public Room createRoom(int aId, boolean ifFree, int aCapacity, Company aCompany) {
		Room room = new Room();
		room.setRoomId(aId);
		room.setIfFree(ifFree);
		room.setCapacity(aCapacity);
		room.setCompany1(aCompany);	
		
		entityManager.persist(room);
		return room;
	}
	
	@Transactional
	public Room getRoom(String aId) {
		Room aRoom = entityManager.find(Room.class, aId);
		return aRoom;
	}
	
	// Course
	
	@Transactional
	public Course createCourse(int aId, String aCourseName, int schoolId, int subjectId) {
		if (aCourseName == null) {
			throw new IllegalArgumentException("Course name cannot be empty!");
		}
		
		Course course = new Course();
		course.setCourseId(aId);
		course.setName(aCourseName);
		
		entityManager.persist(course);
		return course;
	}
	
	@Transactional
	public Course getCourse(String aId) {
		Course aCourse = entityManager.find(Course.class, aId);
		return aCourse;
	}
	
	// School
	
	@Transactional
	public School createSchool(int aId, String aSchoolName, SchoolType schoolType) {
		if (aSchoolName == null) {
			throw new IllegalArgumentException("School name cannot be empty!");
		}
		
		School school = new School();
		school.setSchoolId(aId);
		school.setName(aSchoolName);
		school.setSchoolType(schoolType);

		entityManager.persist(school);
		return school;
	}
	
	@Transactional
	public School getSchool(String aId) {
		School aSchool = entityManager.find(School.class, aId);
		return aSchool;
	}
	
	// Subject
	
	@Transactional
	public Subject createSubject(int aId, String aSubjectName) {
		if (aSubjectName == null) {
			throw new IllegalArgumentException("Subject name cannot be empty!");
		}
		
		Subject subject = new Subject();
		subject.setSubjectId(aId);
		subject.setName(aSubjectName);

		entityManager.persist(subject);
		return subject;
	}
	
	@Transactional
	public Subject getSubject(String aId) {
		Subject aSubject = entityManager.find(Subject.class, aId);
		return aSubject;
	}
	
	// Student
	
	@Transactional
	public Student createStudent(int aId, String aUserName, String aPassword, School aSchool) {
		if (aUserName == null) {
			throw new IllegalArgumentException("Student UserName cannot be empty!");
		}
		
		Student student = new Student();
		student.setUserId(aId);
		student.setUserName(aUserName);
		student.setPassword(aPassword);
		student.setSchool(aSchool);
		
		entityManager.persist(student);
		return student;
	}
	
	@Transactional
	public Student getStudent(String aId) {
		Student aStudent = entityManager.find(Student.class, aId);
		return aStudent;
	}
	
	// Charge
	
	@Transactional
	public Charge createCharge(int aId, Session aSession, int aValue) {
		
		Charge charge = new Charge();
		charge.setChargeId(aId);
		charge.setSession(aSession);
		charge.setValue(aValue);
		
		entityManager.persist(charge);
		return charge;
	}
	
	@Transactional
	public Charge getCharge(String aId) {
		Charge aCharge = entityManager.find(Charge.class, aId);
		return aCharge;
	}

	// Company

	@Transactional
	public Company createCompany(int Id, String Name, int startTime, int endTime) {
		if (Name == null) {
			throw new IllegalArgumentException("Company name cannot be empty!");
		}
		else if (startTime >= endTime) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		
		Company company = new Company();
		company.setCloseTime(endTime);
		company.setOpenTime(startTime);
		company.setName(Name);
		company.setCompanyId(Id);
		
		entityManager.persist(company);
		return company;
	}
	
	@Transactional
	public Company getCompany(String name) {
		Company ourCompany = entityManager.find(Company.class, name);
		return ourCompany;
	}
	
	// User
	
	@Transactional
	public User createUser(int aId, Company aCompany, String aUserName, String aPassword) {
		if (aUserName == null) {
			throw new IllegalArgumentException("UserName cannot be empty!");
		}
		
		User user = new User();
		user.setUserId(aId);
		user.setCompany(aCompany);
		user.setUserName(aUserName);
		user.setPassword(aPassword);
		
		entityManager.persist(user);
		return user;
	}
	
	@Transactional
	public User getUser(String aId) {
		User aUser = entityManager.find(User.class, aId);
		return aUser;
	}
	
	// Tutor
	
	@Transactional
	public Tutor createTutor(int aId, String aUserName, String aPassword, Company aC, Subject aSubject) {
		if (aUserName == null) {
			throw new IllegalArgumentException("Tutor UserName cannot be empty!");
		}
		
		Tutor tutor = new Tutor();
		tutor.setUserId(aId);
		tutor.setUserName(aUserName);
		tutor.setPassword(aPassword);
		tutor.setCompany(aC);
		tutor.setSubject(aSubject);

		entityManager.persist(tutor);
		return tutor;
	}
	
	@Transactional
	public Tutor getTutor(String aId) {
		Tutor aTutor = entityManager.find(Tutor.class, aId);
		return aTutor;
	}
	
	
}

