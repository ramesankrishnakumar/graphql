package home.krishna.graphql.response;

import home.krishna.graphql.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StudentResponse {

    private long id;

    private String firstName;

    private String lastName;

    private String email;

    private String street;

    private String city;

    private List<SubjectResponse> learningSubjects;

    private Student dummyStudent;

    public StudentResponse(Student student) {
        this.dummyStudent = student;
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.street = student.getAddress().getStreet();
        this.city = student.getAddress().getCity();
    }

}
