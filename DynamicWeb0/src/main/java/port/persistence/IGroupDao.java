package port.persistence;

import java.util.Collection;

import model.Group;

public interface IGroupDao {

	boolean createNewGroup(Group aGroup);

	Group getGroupById(String groupId);

	Collection<Group> getGroupsByOwner(String ownerId);

}