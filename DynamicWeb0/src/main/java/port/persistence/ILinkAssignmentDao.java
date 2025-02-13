package port.persistence;

import java.util.Collection;

import model.LinkAssignment;

public interface ILinkAssignmentDao {

	boolean addNewLinkAssignment(LinkAssignment assignment);

	Collection<LinkAssignment> getLinkAssignmentsForTest(String testId);

	Collection<LinkAssignment> getlinkAssignmentsForLink(String linkId);

}
