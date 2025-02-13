package model;

public class Test implements ITest {
	
	private String name;
	private String testId;
	private String categoryId;
	private String testOwnerId;
	private TestStatus status = TestStatus.AVAILABLE;
	
	public Test() {
	}

	public Test(String name) {
		this.name = name;
	}

	public String getOwnerId() {
		return this.testOwnerId;
	}
	public void setOwnerId(String ownerId) {
		this.testOwnerId = ownerId;
	}
	
	public void setId(String id) {
		this.testId = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getId() {
		return this.testId;
	}
	public String getName() {
		return this.name;
	}
	public void setStatus(TestStatus aStatus) {
		this.status = aStatus;
	}
	public TestStatus getStatus() {
		return this.status;
	}
	
	public static Test create(String testId, String testName, String categoryId, String ownerId) {
		Test aTest = new Test();
		aTest.setId(testId);
		aTest.setName(testName);
		aTest.setCategoryId(categoryId);
		aTest.setOwnerId(ownerId);
		return aTest;
	}

}
