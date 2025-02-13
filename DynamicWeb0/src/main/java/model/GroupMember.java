package model;

public class GroupMember {

	private String memberId;
	private String userId;
	
	public static GroupMember create(String memberId, String userId) {
		return new GroupMember(memberId, userId);
	}
	public GroupMember(String memberId, String userId) {
		super();
		this.memberId = memberId;
		this.userId = userId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void changeUsername(String aUsername) {
		
	}
	
}
