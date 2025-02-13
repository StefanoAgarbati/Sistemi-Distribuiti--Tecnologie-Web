package model;

public class Group {

	private String groupId;
	private String ownerId;
	private String name;

	public static Group create(String groupId, String groupName, String ownerId) {
		Group aGroup = new Group();
		aGroup.setGroupId(groupId);
		aGroup.setName(groupName);
		aGroup.setOwnerId(ownerId);
		return aGroup;
	}
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
