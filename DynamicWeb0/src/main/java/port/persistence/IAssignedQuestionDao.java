package port.persistence;

import java.util.List;

import model.AssignedQuestion;
import model.IAssignedQuestion;

public interface IAssignedQuestionDao {

	String create(IAssignedQuestion assignedQuestion);

	List<AssignedQuestion> allQuestionAssignedToTest(String testId);

}
