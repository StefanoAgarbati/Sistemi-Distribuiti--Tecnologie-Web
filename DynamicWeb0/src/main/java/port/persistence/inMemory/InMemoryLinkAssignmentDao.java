package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.LinkAssignment;
import port.persistence.ILinkAssignmentDao;
import utils.CollectionsUtils;

public class InMemoryLinkAssignmentDao implements ILinkAssignmentDao {

	private Collection<LinkAssignment> assignments = new LinkedList<>();
	
	@Override
	public boolean addNewLinkAssignment(LinkAssignment assignment) {
		return assignments.add(assignment);
	}

	@Override
	public Collection<LinkAssignment> getLinkAssignmentsForTest(String testId) {
		return CollectionsUtils.filter(assignments, assignment -> assignment.getTestId().equals(testId));
	}

	@Override
	public Collection<LinkAssignment> getlinkAssignmentsForLink(String linkId) {
		return CollectionsUtils.filter(assignments, assignment -> assignment.getLinkId().equals(linkId));
	}

}
