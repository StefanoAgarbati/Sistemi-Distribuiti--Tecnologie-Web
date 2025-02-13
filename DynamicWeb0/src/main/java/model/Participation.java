package model;

public class Participation {

	private String participationId;
	private String groupId;
	private String memberId;
	
	public static Participation create(String participationId, String groupId, String memberId) {
		return new Participation(participationId, groupId, memberId);
	}
	public Participation(String participationId, String groupId, String memberId) {
		super();
		this.participationId = participationId;
		this.groupId = groupId;
		this.memberId = memberId;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getParticipationId() {
		return participationId;
	}
	public void setParticipationId(String participationId) {
		this.participationId = participationId;
	}
}
