package home.krishna.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import home.krishna.graphql.request.SampleRequest;
import home.krishna.graphql.response.StudentResponse;
import home.krishna.graphql.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component @AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    private StudentService service;

    public String firstQuery() {
        return "firstQuery";
    }

    public String fullName(SampleRequest sampleRequest) {
        return sampleRequest.getFirstName() + ":" + sampleRequest.getLastName();
    }

    public StudentResponse student(Long id) {
        return new StudentResponse(service.getStudentById(id));
    }


}
