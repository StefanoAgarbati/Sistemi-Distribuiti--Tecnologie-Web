package model;

public class MemberRegistrationCode {

	private String id;
	private String groupId;
	private String code;
	
	
	public static MemberRegistrationCode create(String id, String groupId, String code) {
		return new MemberRegistrationCode(id, groupId, code);
	}

	public MemberRegistrationCode(String id, String groupId, String code) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.code = code;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
