package model;

public class GroupAssignment {

	private String testId;
	private String groupId;

	public GroupAssignment(String testId, String groupId) {
		super();
		this.testId = testId;
		this.groupId = groupId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public static GroupAssignment create(String testId, String groupId) {
		return new GroupAssignment(testId, groupId);
	}

}
