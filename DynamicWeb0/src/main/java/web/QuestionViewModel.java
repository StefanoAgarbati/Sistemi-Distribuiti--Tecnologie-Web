package web;

import java.util.List;

public class QuestionViewModel {

	private String text;
	private List<AnswerViewModel> answers;
	
	public QuestionViewModel(String text, List<AnswerViewModel> answers) {
		this.text = text;
		this.answers = answers;
	}

	public String getText() {
		return text;
	}

	public List<AnswerViewModel> getAnswers() {
		return answers;
	}
	public void addAnswer(AnswerViewModel anAnswer) {
		answers.add(anAnswer);
	}
	
	
}
