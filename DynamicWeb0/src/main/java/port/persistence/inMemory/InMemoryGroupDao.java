package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import model.Group;
import port.persistence.IGroupDao;
import utils.CollectionsUtils;

public class InMemoryGroupDao implements IGroupDao {

	private Collection<Group> groups = new LinkedList<>();
	
	public InMemoryGroupDao() {
		init();
	}
	
	private void init() {
		Group g0 = Group.create("1", "Group 1", "1");
		Group g1 = Group.create("2", "Group 2", "1");
		
		this.createNewGroup(g0);
		this.createNewGroup(g1);
	}
	@Override
	public boolean createNewGroup(Group aGroup) {
		return this.groups.add(aGroup);
	}
	@Override
	public Group getGroupById(String groupId) {
		List<Group> groupList = CollectionsUtils.filter(this.groups, group -> group.getGroupId().equals(groupId));
		if(groupList.isEmpty())
			return null;
		return groupList.get(0);
	}
	
	@Override
	public Collection<Group> getGroupsByOwner(String ownerId) {
		Collection<Group> someGroups = new LinkedList<>();
		someGroups = CollectionsUtils.filter(groups, group -> group.getOwnerId().equals(ownerId));
		return someGroups;
	}
}
