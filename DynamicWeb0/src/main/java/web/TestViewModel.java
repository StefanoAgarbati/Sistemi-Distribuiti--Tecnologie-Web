package web;

public class TestViewModel {
	
	private int id;
	private String name;
	private int assignedCount;
	
	public TestViewModel(int id, String name, int assignedCount) {
		this.id = id;
		this.name = name;
		this.assignedCount = assignedCount;
	}

	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}

	public int getAssignedCount() {
		return assignedCount;
	}
	
	
	
}
