package web;

public class AnswerViewModel {

	private String index;
	private String text;
	private boolean isCorrect;
	
	public AnswerViewModel(String index, String text, boolean isCorrect) {
		this.index = index;
		this.text = text;
		this.isCorrect = isCorrect;
	}
	public String getIndex() {
		return index;
	}
	public String getText() {
		return text;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
}
