package home.krishna.graphql.service;

import home.krishna.graphql.entity.Address;
import home.krishna.graphql.entity.Student;
import home.krishna.graphql.entity.Subject;
import home.krishna.graphql.repository.AddressRepository;
import home.krishna.graphql.repository.StudentRepository;
import home.krishna.graphql.repository.SubjectRepository;
import home.krishna.graphql.request.CreateStudentRequest;
import home.krishna.graphql.request.CreateSubjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	StudentRepository studentRepository;
	@Transactional(readOnly = true)
	public Student getStudentById (long id) {
		return studentRepository.findById(id).get();
	}

	@Transactional(readOnly = false)
	public Student createStudent (CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);

		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());

		address = addressRepository.save(address);

		student.setAddress(address);
		student = studentRepository.save(student);

		List<Subject> subjectsList = new ArrayList<Subject>();

		if(createStudentRequest.getSubjectsLearning() != null) {
			for (CreateSubjectRequest createSubjectRequest :
					createStudentRequest.getSubjectsLearning()) {
				Subject subject = new Subject();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);

				subjectsList.add(subject);
			}

			subjectRepository.saveAll(subjectsList);

		}

		student.setLearningSubjects(subjectsList);

		return student;
	}
}
