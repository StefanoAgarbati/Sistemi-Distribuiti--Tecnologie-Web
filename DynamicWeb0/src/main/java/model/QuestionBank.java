package model;

import java.util.*;

public class QuestionBank {
	
	private List<Question> questions = new ArrayList<>();
	private int questionsCount;
	
	
	public void addQuestion(Question aQuestion) {
		questions.add(aQuestion);
	}
	public List<Question> getQuestions() {
		return this.questions;
	}
	public int getTotalNumberOfQuestions() {
		return this.questions.size();
	}
}
