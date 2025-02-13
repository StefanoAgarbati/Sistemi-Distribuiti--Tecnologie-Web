package model;

public class TestResult {

	private String id;
	private String takerId;
	private String testId;
	private String date;
	private String duration;
	private float points;
	private float totalPoints;
	
	public static TestResult create(String id,String takerId, String testId, String date, String duration, float points, float totalPoints) {
		return new TestResult(id, takerId, testId, date,duration, points, totalPoints);
	}
	public TestResult(String id, String takerId, String testId, String date, String duration, float points, float totalPoints) {
		super();
		this.id = id;
		this.takerId = takerId;
		this.testId = testId;
		this.date = date;
		this.duration = duration;
		this.points = points;
		this.totalPoints = totalPoints;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTakerId() {
		return takerId;
	}


	public void setTakerId(String takerId) {
		this.takerId = takerId;
	}


	public String getTestId() {
		return testId;
	}


	public void setTestId(String testId) {
		this.testId = testId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDuration() {
		return duration;
	}

	
	public void setDuration(String duration) {
		this.duration = duration;
	}


	public float getPoints() {
		return points;
	}


	public void setPoints(float points) {
		this.points = points;
	}


	public float getTotalPoints() {
		return totalPoints;
	}


	public void setTotalPoints(float totalPoints) {
		this.totalPoints = totalPoints;
	}


	public float getPercentage() {
		float percentage = Math.round((getPoints() / getTotalPoints()) * 100) / 100F;
		return percentage * 100F;
		
	}
	
	public String getScore() {
		String score = "" + getPoints() + "/" + getTotalPoints();
		return score;
	}
	
	
}
