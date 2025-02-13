package application;

import java.util.Collection;
import java.util.LinkedList;

import model.Group;
import model.GroupAssignment;
import model.Link;
import model.LinkAssignment;
import port.persistence.IGroupAssignmentDao;
import port.persistence.IGroupDao;
import port.persistence.ILinkAssignmentDao;
import port.persistence.ILinkDao;

public class AssignmentService {

	private IGroupAssignmentDao groupAssignmentDao;
	private ILinkAssignmentDao linkAssignmentDao;
	private IGroupDao groupDao;
	private ILinkDao linkDao;

	public AssignmentService(IGroupAssignmentDao groupAssignmentDao, ILinkAssignmentDao linkAssignmentDao,
			IGroupDao groupDao, ILinkDao linkDao) {
		super();
		this.groupAssignmentDao = groupAssignmentDao;
		this.linkAssignmentDao = linkAssignmentDao;
		this.groupDao = groupDao;
		this.linkDao = linkDao;
	}

	public boolean assignTestToGroup(String testId, String groupId) {
		return this.groupAssignmentDao.addNewGroupAssignment(new GroupAssignment(testId, groupId));
	}

	public boolean assignTestToLink(String testId, String linkId) {
		return this.linkAssignmentDao.addNewLinkAssignment(new LinkAssignment(testId, linkId));

	}

	public Collection<GroupAssignment> getGroupAssignmentsForTest(String testId) {
		return this.groupAssignmentDao.getGroupAssignmentsForTest(testId);
	}

	public Collection<GroupAssignment> getGroupAssignmentsForGroup(String groupId) {
		return this.groupAssignmentDao.getGroupAssignmentsForGroup(groupId);
	}

	public Collection<LinkAssignment> getLinkAssignmentsForTest(String testId) {
		return this.linkAssignmentDao.getLinkAssignmentsForTest(testId);
	}

	public Collection<LinkAssignment> getLinkAssignmentsForGroup(String linkId) {
		return this.linkAssignmentDao.getlinkAssignmentsForLink(linkId);
	}

	public Collection<Group> getGroupsForTest(String testId) {
		Collection<GroupAssignment> assignments = this.getGroupAssignmentsForTest(testId);
		Collection<Group> groups = new LinkedList<>();
		assignments.forEach(item -> groups.add(this.groupDao.getGroupById(item.getGroupId())));
		return groups;
	}

	public Collection<Link> getLinksForTest(String testId) {
		Collection<LinkAssignment> assignments = this.getLinkAssignmentsForTest(testId);
		Collection<Link> links = new LinkedList<>();
		assignments.forEach(item -> links.add(this.linkDao.getLinkById(item.getLinkId())));
		return links;
	}
	public boolean isTestAssignedToGroup(String testId, String groupId) {
		Collection<GroupAssignment> assignments = this.groupAssignmentDao.getGroupAssignmentsForTest(testId);
		for(GroupAssignment assignment : assignments) {
			if(assignment.getGroupId().equals(groupId))
				return true;
		}
		return false;
	}

}
