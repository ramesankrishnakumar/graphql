package home.krishna.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import home.krishna.graphql.entity.Subject;
import home.krishna.graphql.filter.SubjectNameFilter;
import home.krishna.graphql.response.StudentResponse;
import home.krishna.graphql.response.SubjectResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service @Transactional
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse, SubjectNameFilter filter) {
        List<SubjectResponse> learningSubjects = new ArrayList<SubjectResponse>();
        if (studentResponse.getDummyStudent().getLearningSubjects() != null) {
            for (Subject subject : studentResponse.getDummyStudent().getLearningSubjects()) {
                if(filter.equals(SubjectNameFilter.ALL))
                    learningSubjects.add(new SubjectResponse(subject));
                else if(filter.name().equalsIgnoreCase(subject.getSubjectName()))
                    learningSubjects.add(new SubjectResponse(subject));
            }
        }
        return learningSubjects;
    }
}
