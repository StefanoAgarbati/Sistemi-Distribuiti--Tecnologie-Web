package port.persistence;

import java.util.Collection;

import model.GroupAssignment;

public interface IGroupAssignmentDao {

	boolean addNewGroupAssignment(GroupAssignment assignment);

	Collection<GroupAssignment> getGroupAssignmentsForTest(String testId);

	Collection<GroupAssignment> getGroupAssignmentsForGroup(String groupId);

}
