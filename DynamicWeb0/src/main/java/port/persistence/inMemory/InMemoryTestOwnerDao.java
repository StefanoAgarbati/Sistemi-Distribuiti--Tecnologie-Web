package port.persistence.inMemory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.TestOwner;
import port.persistence.ITestOwnerDao;
import utils.CollectionsUtils;

public class InMemoryTestOwnerDao implements ITestOwnerDao {
	
	private Collection<TestOwner> owners = new ArrayList<>();
	
	public boolean addNewTestOwner(TestOwner aTestOwner) {
		return owners.add(aTestOwner);
	}
	public boolean deleteTestOwner(String id) {
		List<TestOwner> owner = CollectionsUtils.filter(owners, own -> own.getId().equals(id));
		if(owner.isEmpty())
			return false;
		return owners.remove(owner.get(0));
	}
	public TestOwner getOwnerByUsername(String username) {
		List<TestOwner> result = CollectionsUtils.filter(owners, owner -> owner.getRegisteredUserId().equals(username));
		if(result.isEmpty())
			return null;
		return result.get(0);
	}
	public TestOwner getOwnerById(String id) {
		List<TestOwner> result = CollectionsUtils.filter(owners, owner -> owner.getId().equals(id));
		if(result.isEmpty())
			return null;
		return result.get(0);
	}
}
