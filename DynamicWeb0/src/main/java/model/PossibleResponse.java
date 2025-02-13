package model;

public class PossibleResponse {

	public static PossibleResponse create(String resId, String questionId, boolean isCorrect, String text, String name) {
		return new PossibleResponse(resId, questionId, isCorrect, text, name);
	}
	private boolean isCorrect;
	private String name;
	private String questionId;
	private String responseId;
	
	private String text;

	public PossibleResponse() {
	}
	
	public PossibleResponse(String resId, String questionId, boolean isCorrect, String text, String name) {
		setText(text);
		this.setAsCorrect(isCorrect);
		this.responseId = resId;
		this.name = name;
		this.questionId = questionId;
	}
	public String getName() {
		return this.name;
	}

	public String getQuestionId() {
		return this.questionId;
	}

	public String getResponseId() {
		return responseId;
	}
	public String getText() {
		return this.text;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	
	public String questionId() {
		return this.questionId;
	}
	
	public String responseId() {
		return this.responseId;
	}
	
	public void setAsCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}
	public void setName(String aName) {
		this.name = aName;
	}
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	public void setText(String aText) {
		this.text = aText; 
	}
	
}
