package port.persistence;

import java.util.Collection;

import model.GroupAssignment;
import model.LinkAssignment;

public interface IAssignmentDao {

	boolean createGroupAssignment(GroupAssignment aGroupAssignment);
	
	boolean createLinkAssignment(LinkAssignment linkAssignment);
	
	Collection<GroupAssignment> getGroupAssignmentsForTest(String testId);
	
	Collection<LinkAssignment> getLinkAssignmentsForTest(String testId);

	Collection<GroupAssignment> getGroupAssignmentsForGroup(String groupId);

	Collection<LinkAssignment> getLinkAssignmentsForLink(String linkId);

	
}
