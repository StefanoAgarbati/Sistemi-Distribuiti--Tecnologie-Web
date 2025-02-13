package application;

import java.util.Collection;
import java.util.LinkedList;

import model.GroupMember;
import model.MemberRegistrationCode;
import model.Participation;
import model.RegisteredUser;
import model.Roles;
import port.persistence.IGroupMemberDao;
import port.persistence.IParticipationDao;
import port.persistence.IdGenerator;
import utils.OutUtils;
import utils.PasswordGenerator;

public class GroupMemberService {
	
	private IGroupMemberDao memberDao;
	private IParticipationDao participationDao;
	private RegistrationService registrationService;
	private RegistrationCodeService codeService;
	private PasswordGenerator passwordGenerator;
	
	public GroupMemberService(IGroupMemberDao groupMemberDao, IParticipationDao participationDao) {
		this.memberDao = groupMemberDao;
		this.participationDao = participationDao;
		this.passwordGenerator = new PasswordGenerator();
		this.registrationService = ServiceFactory.createRegistrationService();
		this.codeService = ServiceFactory.createRegistrationCodeService();
		
	}
	public void addMemberToGroup(String firstname, String lastname, String email, String groupId) {
		String username = this.registerNewUser(firstname, lastname);
		System.out.println("addMemberToGroup-MemberService - username " + username);
		RegisteredUser user = this.registrationService.getUserByUsername(username);
		System.out.println("addMemberToGroup-MemberService - user " + user);
		this.addUserToGroup(user.getUserId(), groupId);
	}
	public void addMemberToGroupByCode(String userId, String code) {
		MemberRegistrationCode registrationCode = this.codeService.getMemberRegistrationCodeById(code);
		System.out.println("addMemberToGroupByCode-code " + registrationCode.getCode());
		System.out.println("addMemberToGroupByCode-id " + registrationCode.getId());
		System.out.println("addMemberToGroupByCode-groupId " + registrationCode.getGroupId());
		System.out.println("addMemberToGroupByCode-userId " + userId);
		String groupId = registrationCode.getGroupId();
		this.addUserToGroup(userId, groupId);
	}
	private void addUserToGroup(String userId, String groupId) {
		GroupMember groupMember = GroupMember.create(IdGenerator.generateId(), userId);
		Participation participation = Participation.create(IdGenerator.generateId(), groupId, groupMember.getMemberId());
		this.participationDao.createParticipation(participation);
		this.memberDao.addMemberToGroup(groupMember);
	}
	public GroupMember getMemberByUserId(String userId) {
		GroupMember member = this.memberDao.getMemberByUserId(userId);
		System.out.println("getMemberByUserId-userId" + member.getUserId());
		System.out.println("getMemberByUserId-memberId" + member.getMemberId());
		return member;
	}
	public GroupMember getMemberById(String memberId) {
		return this.memberDao.getMemberById(memberId);
	}
	public Collection<Participation> getParticipationsByMember(String memberId) {
		return this.participationDao.getParticipationByMember(memberId);
	}
	public Collection<Participation> getParticipationsByGroup(String groupId) {
		return participationDao.getParticipationByGroup(groupId);
	}
	public Collection<GroupMember> getMembersByGroup(String groupId) {
		Collection<Participation> participations = getParticipationsByGroup(groupId);
		Collection<GroupMember> members = new LinkedList<>();
		OutUtils.out("GetMembersByGroup members list created " + members);
		for(Participation p : participations) {
			GroupMember aMember = this.memberDao.getMemberById(p.getMemberId());
			members.add(aMember);
			OutUtils.out("GroupMemberService getMembersByGroup " + members.size());
		}
		OutUtils.out("GroupMemberService getMembersByGroup " + members);
		return members;
	}
	private String registerNewUser(String firstname, String lastname) {
		String password = createPassword();
		String username = firstname+lastname;
		for(int i = 0;;i++) {
			boolean registrationOk = this.registrationService.registerNewUser(Roles.taker, username, password, firstname, lastname);
			if(registrationOk)
				break;
			username = firstname+lastname+i;
		}
		return username;
	}
	private String createPassword() {
		return this.passwordGenerator.generatePassword(8, true, true, true, false);
	}
}
