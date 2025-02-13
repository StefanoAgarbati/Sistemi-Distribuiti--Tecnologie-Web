package model;

public class TestQuestion {

	private String testId;
	private String questionId;
	
	public static TestQuestion create(String testId, String questionId) {
		TestQuestion tq = new TestQuestion();
		tq.setTestId(testId);
		tq.setQuestionId(questionId);
		return tq;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getQuestionId() {
		return this.questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public boolean hasTestId(String testId) {
		return this.testId.equals(testId);
	}
	public boolean hasQuestionId(String questionId) {
		return this.questionId.equals(questionId);
	}
	
}
