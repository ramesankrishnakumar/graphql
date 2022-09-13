package home.krishna.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import home.krishna.graphql.request.CreateStudentRequest;
import home.krishna.graphql.response.StudentResponse;
import home.krishna.graphql.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentMutation implements GraphQLMutationResolver {
    @Autowired
    StudentService studentService;
    public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
       return new StudentResponse(studentService.createStudent(createStudentRequest));
    }
}
