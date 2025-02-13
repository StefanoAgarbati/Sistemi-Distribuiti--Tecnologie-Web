package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.GroupAssignment;
import model.LinkAssignment;
import port.persistence.IAssignmentDao;
import utils.CollectionsUtils;

public class InMemoryAssignmentDao implements IAssignmentDao {

	private Collection<GroupAssignment> groupAssignments = new LinkedList<>();
	private Collection<LinkAssignment> linkAssignments = new LinkedList<>();

	public InMemoryAssignmentDao() {
		init();
	}
	public boolean createGroupAssignment(GroupAssignment aGroupAssignment) {
		return this.groupAssignments.add(aGroupAssignment);

	}

	public boolean createLinkAssignment(LinkAssignment aLinkAssignment) {
		return this.linkAssignments.add(aLinkAssignment);

	}

	@Override
	public Collection<GroupAssignment> getGroupAssignmentsForTest(String testId) {
		return CollectionsUtils.filter(groupAssignments, assignment -> assignment.getTestId().equals(testId));
	}
	@Override
	public Collection<LinkAssignment> getLinkAssignmentsForTest(String testId) {
		return CollectionsUtils.filter(linkAssignments, assignment -> assignment.getTestId().equals(testId));
	}
	@Override
	public Collection<GroupAssignment> getGroupAssignmentsForGroup(String groupId) {
		return CollectionsUtils.filter(groupAssignments, assignment -> assignment.getGroupId().equals(groupId));
	}
	@Override
	public Collection<LinkAssignment> getLinkAssignmentsForLink(String linkId) {
		return CollectionsUtils.filter(linkAssignments, assignment -> assignment.getLinkId().equals(linkId));
	}
	
	private void init() {
		GroupAssignment ga0 = GroupAssignment.create("1","1");
		GroupAssignment ga1 = GroupAssignment.create("2","1");
		LinkAssignment la0 = LinkAssignment.create("1","1");
		LinkAssignment la1 = LinkAssignment.create("2","2");
		
		this.createGroupAssignment(ga0);
		this.createGroupAssignment(ga1);
		this.createLinkAssignment(la0);
		this.createLinkAssignment(la1);
		
	}
	
}
