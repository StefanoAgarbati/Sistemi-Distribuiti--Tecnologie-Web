package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.GroupAssignment;
import port.persistence.IGroupAssignmentDao;
import utils.CollectionsUtils;

public class InMemoryGroupAssignmentDao implements IGroupAssignmentDao {

	private Collection<GroupAssignment> assignments = new LinkedList<>();
	
	public InMemoryGroupAssignmentDao() {
		init();
	}
	@Override
	public boolean addNewGroupAssignment(GroupAssignment assignment) {
		return assignments.add(assignment);
	}

	@Override
	public Collection<GroupAssignment> getGroupAssignmentsForTest(String testId) {
		return CollectionsUtils.filter(assignments, assignment -> assignment.getTestId().equals(testId));
	}

	@Override
	public Collection<GroupAssignment> getGroupAssignmentsForGroup(String groupId) {
		Collection<GroupAssignment> someAssignments = CollectionsUtils.filter(assignments, assignment -> {
			return assignment.getGroupId().equals(groupId);
		});
		return someAssignments;
	}
	
	private void init() {
		GroupAssignment g0 = GroupAssignment.create("1", "1");
		GroupAssignment g1 = GroupAssignment.create("2", "1");
		
		this.addNewGroupAssignment(g0);
		this.addNewGroupAssignment(g1);
	}

}
