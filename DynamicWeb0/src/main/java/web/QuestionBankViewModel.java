package web;

import java.util.ArrayList;
import java.util.List;

import model.Question;

public class QuestionBankViewModel {
	
	private List<QuestionViewModel> questions = new ArrayList<>();
	
	public QuestionBankViewModel() {
		AnswerViewModel a1 = new AnswerViewModel("A","answer A?",false);
		AnswerViewModel a2 = new AnswerViewModel("B","answer B?",true);
		AnswerViewModel a3 = new AnswerViewModel("C","answer C?",false);
		List<AnswerViewModel> answers = new ArrayList<>();
		
		answers.add(a1);
		answers.add(a2);
		answers.add(a3);
		QuestionViewModel q1 = new QuestionViewModel("Question 1", answers);
		
		
	}
	
	public List<QuestionViewModel> getQuestions() {
		return this.questions;
	}
	
	
}
