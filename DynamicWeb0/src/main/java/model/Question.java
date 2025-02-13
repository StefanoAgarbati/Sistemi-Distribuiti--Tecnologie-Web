package model;


public class Question implements IQuestion {

	private String text;
	private String questionId;
	private float points;
	private String ownerId;
	private String categoryId;
	
	public static Question create(String questionId, String text, float points, String ownerId, String categoryId) {
		return new Question(text, questionId, points, ownerId, categoryId);
	}
	
	public Question(String text, String questionId, float points, String ownerId, String categoryId) {
		super();
		this.text = text;
		this.questionId = questionId;
		this.points = points;
		this.ownerId = ownerId;
		this.categoryId = categoryId;
	}

	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public float getPoints() {
		return points;
	}
	public void setPoints(float points) {
		this.points = points;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
