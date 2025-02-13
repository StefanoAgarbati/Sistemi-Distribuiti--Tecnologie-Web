package model;

public class LinkAssignment {

	private String testId;
	private String linkId;

	public LinkAssignment(String testId, String linkId) {
		super();
		this.testId = testId;
		this.linkId = linkId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getLinkId() {
		return linkId;
	}

	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}

	public static LinkAssignment create(String testId, String linkId) {
		return new LinkAssignment(testId, linkId);
	}

}
