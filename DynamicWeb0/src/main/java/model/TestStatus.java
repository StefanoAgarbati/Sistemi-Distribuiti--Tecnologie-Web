package model;

public enum TestStatus {

	AVAILABLE("Available"),
	UNAVAILABLE("Unavailable");

	private String status;
	
	TestStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	
}
