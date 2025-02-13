package model;

public class AssignedQuestion implements IAssignedQuestion {

	private String testId;
	private String questionId;
	private Test test;
	private Question question;
	
	public AssignedQuestion(String testId, String questionId) {
		testId(testId);
		questionId(questionId);
	}

	public AssignedQuestion(Test test, Question aQuestion) {
		this.test = test;
		this.question = aQuestion;
	}

	private void questionId(String questionId) {
		this.questionId = questionId;
	}

	private void testId(String testId) {
		this.testId = testId;
	}
	
	public String testId() {
		return this.testId;
	}
	public String questionId() {
		return this.questionId;
	}
	
	
	
}
