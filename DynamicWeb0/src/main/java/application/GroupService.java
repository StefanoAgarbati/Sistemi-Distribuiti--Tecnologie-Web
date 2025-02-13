package application;


import java.util.Collection;

import model.Group;
import model.MemberRegistrationCode;
import port.persistence.IGroupDao;
import port.persistence.IMemberRegistrationCodeDao;
import port.persistence.IdGenerator;
import utils.PasswordGenerator;

public class GroupService {

	private IGroupDao groupDao;
	
	public GroupService(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}
	public boolean createNewGroup(String groupName, String ownerId) {
		Group aGroup = Group.create(IdGenerator.generateId(), groupName, ownerId);
		return this.groupDao.createNewGroup(aGroup);
	}
	public boolean deleteGroup(String groupId) {
		return false;
	}
	public boolean addMemberToGroup(String groupId, String memberId) {
		return false;
	}
	public boolean deleteMemberFromGroup(String groupId, String memberId) {
		return false;
	}
	public Collection<Group> getGroupsByOwner(String ownerId) {
		return this.groupDao.getGroupsByOwner(ownerId);
	}
	public Group getGroupById(String groupId) {
		return this.groupDao.getGroupById(groupId);
	}
	
}
