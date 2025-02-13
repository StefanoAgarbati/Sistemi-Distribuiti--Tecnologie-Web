package port.interfaces.web;

import application.MTestService;

public class ManageTestBean {

	private String testName;
	private int numberOfQuestion;
	private int questionsInBank;
	private MTestService testService;
	
	public String getTestName() {
		return this.testName; 
	}
	public int getNumberOfQuestions() {
		return this.numberOfQuestion;
	}
	public int getQuestionsInBank() {
		return this.questionsInBank;
	}
}
