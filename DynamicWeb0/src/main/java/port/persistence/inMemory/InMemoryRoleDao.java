package port.persistence.inMemory;

import java.util.ArrayList;
import java.util.Collection;

import model.UserRole;
import port.persistence.IRoleDao;

public class InMemoryRoleDao implements IRoleDao {

	private Collection<UserRole> roles = new ArrayList<>();
	
	public InMemoryRoleDao() {
		init();
	}
	
	@Override
	public UserRole getRoleById(String roleId) {
		for(UserRole ur : roles) {
			if(ur.getId().equals(roleId))
				return ur;
		}
		return null;
	}
	
	private void init() {
		UserRole r0 = UserRole.create("1", "educator");
		UserRole r1 = UserRole.create("2", "taker");
		
		roles.add(r0);
		roles.add(r1);
	}
	
	
}
