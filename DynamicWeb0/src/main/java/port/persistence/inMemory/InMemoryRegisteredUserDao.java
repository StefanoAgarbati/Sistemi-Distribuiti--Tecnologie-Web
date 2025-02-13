package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.RegisteredUser;
import model.Role;
import port.persistence.IRegisteredUserDao;
import port.persistence.RegisteredUserDao;
import utils.CollectionsUtils;
import utils.OutUtils;

public class InMemoryRegisteredUserDao implements IRegisteredUserDao {

	private Collection<RegisteredUser> users = new LinkedList<>();
	
	public InMemoryRegisteredUserDao() {
		init();
	}
	@Override
	public RegisteredUser findByUsername(String username) {
		return CollectionsUtils.filterOne(users, user -> user.hasUsername(username));
	}

	@Override
	public RegisteredUser findById(String userId) {
		return CollectionsUtils.filterOne(users, user-> user.getUserId().equals(userId));
	}
	
	@Override
	public boolean registerNewUser(RegisteredUser registeredUser) {
		boolean result = users.add(registeredUser);
		OutUtils.out("InMemoryRegisteredUser: User added " + registeredUser.getFirstname() + " " + registeredUser.getLastname());
		return result;
	}

	@Override
	public boolean removeRegisteredUser(RegisteredUser aUser) {
		return false;
	}

	@Override
	public boolean changeUserPassword(String username, String newPassword) {
		return false;
	}
	
	private void init() {
		RegisteredUser u0 = RegisteredUser.create("1", "stefano", "1234", "Stefano", "Agarbati", Role.educator);
		RegisteredUser u1 = RegisteredUser.create("2", "gino", "1234", "Gino", "Paoletti", Role.educator);
		RegisteredUser u3 = RegisteredUser.create("3", "giuseppeagarbati", "1234", "Giuseppe", "Agarbati", Role.taker);
		this.registerNewUser(u0);
		this.registerNewUser(u1);
		this.registerNewUser(u3);
	}
	

}
