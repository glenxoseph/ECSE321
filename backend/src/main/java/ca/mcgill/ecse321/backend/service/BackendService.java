package ca.mcgill.ecse321.backend.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.backend.dao.ChargeRepository;
import ca.mcgill.ecse321.backend.dao.CompanyRepository;
import ca.mcgill.ecse321.backend.dao.CourseRepository;
import ca.mcgill.ecse321.backend.dao.EvaluationRepository;
import ca.mcgill.ecse321.backend.dao.RoomRepository;
import ca.mcgill.ecse321.backend.dao.SchoolRepository;
import ca.mcgill.ecse321.backend.dao.SessionRepository;
import ca.mcgill.ecse321.backend.dao.StudentRepository;
import ca.mcgill.ecse321.backend.dao.SubjectRepository;
import ca.mcgill.ecse321.backend.dao.TutorRepository;
import ca.mcgill.ecse321.backend.dao.UserRepository;
import ca.mcgill.ecse321.backend.jpa.*;

@Service
public class BackendService {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RoomRepository roomRepository;

	@Autowired
	TutorRepository tutorRepository;
	
	@Autowired
	EvaluationRepository evaluationRepository;
	
	@Autowired
	ChargeRepository chargeRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	SchoolRepository schoolRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	// manager confirms review session
	@Transactional
	public void confirmReviewSession(int idSession) {
		ReviewSession session = (ReviewSession) sessionRepository.findSessionBySessionId(idSession);
		session.setIsRequested(false);
		session.setIsConfirmed(true);
	}
	
	// assign tutor for session
	@Transactional
	public void assignTutorForSession(int idSession, int idTutor) {
		Tutor tutor = tutorRepository.findTutorByUserId(idTutor);
		Session session = sessionRepository.findSessionBySessionId(idSession);
		session.setTutor(tutor);
	}
	

	// assign time for session
	@Transactional
	public void assignTimeForSession(int idSession, int startTime, int endTime) {
		Session session = sessionRepository.findSessionBySessionId(idSession);
		session.setStartTime(startTime);
		session.setEndTime(endTime);
	}
	
	// assign room for session
	@Transactional
	public void assignLargeRoomForReviewSession(int idSession, int roomId) {
		LargeRoom room = (LargeRoom) roomRepository.findRoomByRoomId(roomId);
		ReviewSession session = (ReviewSession) sessionRepository.findSessionBySessionId(idSession);
		session.setLargeRoom(room);
	}
	
	// assign small room for session
	@Transactional
	public void assignSmallRoomForTutorSession(int idSession, int roomId) {
		SmallRoom room = (SmallRoom) roomRepository.findRoomByRoomId(roomId);
		TutorSession session = (TutorSession) sessionRepository.findSessionBySessionId(idSession);
		session.setSmallRoom(room);
	}
	
	// assign student to session
	@Transactional
	public void assignStudentForTutorSession(int idSession, int idStudent) {
		Student student = (Student) userRepository.findUserByuserId(idStudent);
		TutorSession session = (TutorSession) sessionRepository.findSessionBySessionId(idSession);
		session.setStudent(student);
	}
	
	// add students
	@Transactional
	public void addStudentsToReviewSession(int idSession, int idStudent) {
		Student student = (Student) userRepository.findUserByuserId(idStudent);
		ReviewSession session = (ReviewSession) sessionRepository.findSessionBySessionId(idSession);
		Set<Student> students = session.getStudents();
		students.add(student);
		session.setStudents(students);
	}
	
	// warn tutor
	@Transactional
	public void warnTutor(int warning, int id) {
		Tutor tutor = tutorRepository.findTutorByUserId(id);
		tutor.setWarning(warning);
	}
	
	// suspend tutor by day
	@Transactional
	public void suspendTutor(int days, int id) {
		Tutor tutor = tutorRepository.findTutorByUserId(id);
		tutor.setSuspended(true);
		tutor.setDaysLeftSuspended(days);
	}
	
	// fire tutor
	@Transactional
	public void fireTutor(int id) {
		Tutor tutor = tutorRepository.findTutorByUserId(id);
		tutor.setfire(true);
	}
	
	// delete evaluation
	@Transactional
	public void deleteEvaluation(int id) {
		Evaluation evaluation = evaluationRepository.findEvaluationByEvalId(id);
		evaluationRepository.delete(evaluation);
	}
	
	// flag evaluation
	@Transactional
	public void flagEvaluation(int id) {
		Evaluation evaluation = evaluationRepository.findEvaluationByEvalId(id);
		evaluation.setIsFlagged(true);
	}
	
	// create tutor
	@Transactional
	public void createTutor(int aId, String aUserName, String aPassword, Company aC, Subject aSubject) {
		if (aUserName == null) {
			throw new IllegalArgumentException("Tutor UserName cannot be empty!");
		}
		if (tutorRepository.findTutorByUserId(aId) != null) {
			throw new IllegalArgumentException("User ID already exists");
		}
		
		Tutor tutor = new Tutor();
		tutor.setUserId(aId);
		tutor.setUserName(aUserName);
		tutor.setPassword(aPassword);
		tutor.setCompany(aC);
		tutor.setSubject(aSubject);
		tutorRepository.save(tutor);
	}
	
	// create company
	@Transactional
	public void createCompany(int Id, String Name, int startTime, int endTime) {
		if (Name == null) {
			throw new IllegalArgumentException("Company name cannot be empty!");
		}
		else if (this.getAllCompanies().size() == 1) {
			throw new IllegalArgumentException("You may only have one company");
		}
		else if (startTime >= endTime) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		
		Company company = new Company();
		company.setCloseTime(endTime);
		company.setOpenTime(startTime);
		company.setName(Name);
		company.setCompanyId(Id);
		companyRepository.save(company);
	}
	
	
	// create student
	@Transactional
	public void createStudent(int aId, String aUserName, String aPassword, School aSchool) {
		if (aUserName == null) {
			throw new IllegalArgumentException("Student UserName cannot be empty!");
		}
		if (studentRepository.findStudentByUserId(aId) != null) {
			throw new IllegalArgumentException("User ID already exists");
		}
		
		Student student = new Student();
		student.setUserId(aId);
		student.setUserName(aUserName);
		student.setPassword(aPassword);
		student.setSchool(aSchool);
		//studentRepository.save(student); // Causes javax.persistence.EntityNotFoundException
	}
	
	// remove student
	@Transactional
	public void removeStudent(int aId) {
		Student student = studentRepository.findStudentByUserId(aId);
		studentRepository.delete(student);
	}
	
	// create subject
	@Transactional
	public void createSubject(int aId, String aSubjectName) {
		if (aSubjectName == null) {
			throw new IllegalArgumentException("Subject name cannot be empty!");
		}
		if (subjectRepository.findSubjectBysubjectId(aId) != null) {
			throw new IllegalArgumentException("Subject ID already exists");
		}
		Subject subject = new Subject();
		subject.setSubjectId(aId);
		subject.setName(aSubjectName);
		subjectRepository.save(subject);
	}
	
	// create school
	@Transactional
	public void createSchool(int aId, String aSchoolName, SchoolType schoolType) {
		if (aSchoolName == null) {
			throw new IllegalArgumentException("School name cannot be empty!");
		}
		if (schoolRepository.findSchoolByschoolId(aId) != null) {
			throw new IllegalArgumentException("School ID already exists");
		}
		
		School school = new School();
		school.setSchoolId(aId);
		school.setName(aSchoolName);
		school.setSchoolType(schoolType);
		schoolRepository.save(school);
	}
	
	// create course
	@Transactional
	public void createCourse(int aId, String aCourseName, int schoolId, int subjectId) {
		if (aCourseName == null) {
			throw new IllegalArgumentException("Course name cannot be empty!");
		}
		if (schoolRepository.findSchoolByschoolId(schoolId) == null) {
			throw new IllegalArgumentException("No such school!");
		}
		if (subjectRepository.findSubjectBysubjectId(subjectId) == null) {
			throw new IllegalArgumentException("No such subject!");
		}
		if (courseRepository.findCourseByCourseId(aId) != null) {
			throw new IllegalArgumentException("Course ID already exists");
		}
		
		Course course = new Course();
		course.setCourseId(aId);
		course.setName(aCourseName);
		course.setSchool(schoolRepository.findSchoolByschoolId(schoolId));
		course.setSubject(subjectRepository.findSubjectBysubjectId(subjectId));
		courseRepository.save(course);
	}
	
	// create room
	@Transactional
	public void createRoom(int aId, boolean ifFree, int aCapacity, Company aCompany) {
		if (roomRepository.findRoomByRoomId(aId) != null) {
			throw new IllegalArgumentException("Room ID already exists");
		}
		Room room = new Room();
		room.setRoomId(aId);
		room.setIfFree(ifFree);
		room.setCapacity(aCapacity);
		room.setCompany1(aCompany);	
		roomRepository.save(room);
	}
	
	// create evaluation
	@Transactional
	public void createEvaluation(int aId, Tutor tutor, Student student, boolean isFlagged, String litEval, int numEval, User aSender) {
		if (evaluationRepository.findEvaluationByEvalId(aId) != null) {
			throw new IllegalArgumentException("Evaluation ID already exists");
		}
		
		Evaluation evaluation = new Evaluation();
		evaluation.setEvalId(aId);
		evaluation.setTutor(tutor);
		evaluation.setStudent(student);
		evaluation.setIsFlagged(isFlagged);
		evaluation.setLitEval(litEval);
		evaluation.setNumEval(numEval);
		evaluation.setSender(aSender);
		//evaluationRepository.save(evaluation); // Causes javax.persistence.EntityNotFoundException
	}
	
	// create charge
	@Transactional
	public void createCharge(int aId, Session aSession, int aValue) {
		if (chargeRepository.findChargeByChargeId(aId) != null) {
			throw new IllegalArgumentException("Charge ID already exists");
		}
		
		Charge charge = new Charge();
		charge.setChargeId(aId);
		charge.setSession(aSession);
		charge.setValue(aValue);
		chargeRepository.save(charge);
	}
	
	// create session
	@Transactional
	public void createSession(int aId, int startTime, int endTime, Charge aCharge, Course aCourse, Tutor aTutor) {
		if (startTime >= endTime) {
			throw new IllegalArgumentException("Start time must be less than end time");
		}
		if (sessionRepository.findSessionBySessionId(aId) != null) {
			throw new IllegalArgumentException("Session ID already exists");
		}
		
		Session session = new Session();
		session.setSessionId(aId);
		session.setStartTime(startTime);
		session.setEndTime(endTime);
		session.setCharge(aCharge);
		session.setCourse(aCourse);
		session.setTutor(aTutor);
		//sessionRepository.save(session); // Causes javax.persistence.EntityNotFoundException
	}
	
	// create user
	@Transactional
	public void createUser(int aId, Company aCompany, String aUserName, String aPassword) {
		if (aUserName == null) {
			throw new IllegalArgumentException("UserName cannot be empty!");
		}
		if (userRepository.findUserByuserId(aId) != null) {
			throw new IllegalArgumentException("User ID already exists");
		}
		
		
		User user = new User();
		user.setUserId(aId);
		user.setCompany(aCompany);
		user.setUserName(aUserName);
		user.setPassword(aPassword);
		aCompany.addUser(user);
		companyRepository.save(aCompany);
		userRepository.save(user);
	}
	
	
	
	@Transactional
	public List<Charge> getAllCharges() {
		return toList(chargeRepository.findAll());
	}
	
	@Transactional
	public List<Company> getAllCompanies() {//should always be 1 but to check
		return toList(companyRepository.findAll());
	}
	
	@Transactional
	public List<Course> getAllCourses() {
		return toList(courseRepository.findAll());
	}
	@Transactional
	public List<Evaluation> getAllEvaluations() {
		return toList(evaluationRepository.findAll());
	}
	@Transactional
	public List<Room> getAllRooms() {
		return toList(roomRepository.findAll());
	}
	@Transactional
	public List<User> getAllUsers() {
		return toList(userRepository.findAll());
	}
	@Transactional
	public List<Session> getAllSessions() {
		return toList(sessionRepository.findAll());
	}
	@Transactional
	public List<School> getAllSchools() {
		return toList(schoolRepository.findAll());
	}
	@Transactional
	public List<Subject> getAllSubjects() {
		return toList(subjectRepository.findAll());
	}
	@Transactional
	public List<Student> getAllStudents() {
		return toList(studentRepository.findAll());
	}
	@Transactional
	public List<Tutor> getAllTutors() {
		return toList(tutorRepository.findAll());
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	// set max price
	@Transactional
	public void setMaxPrice(Tutor tutor, int maxPrice) {
		tutor.setMaxPrice(maxPrice);
	}

	// set min price
	@Transactional
	public void setMinPrice(Tutor tutor, int minPrice) {
		tutor.setMinPrice(minPrice);
	}

}
