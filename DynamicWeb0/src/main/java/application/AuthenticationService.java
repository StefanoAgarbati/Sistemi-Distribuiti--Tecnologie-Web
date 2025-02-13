package application;

import model.RegisteredUser;
import port.persistence.IRegisteredUserDao;

public class AuthenticationService {

	private IRegisteredUserDao userDao;
	
	public AuthenticationService(IRegisteredUserDao userDao) {
		this.userDao = userDao;
	}
	public RegisteredUser authenticateUser(String username, String password) {
		RegisteredUser aUser = userDao.findByUsername(username);
		if(aUser == null)
			return null;
		if(aUser.hasPassword(password))
			return aUser;
		return null;
			
	}
}
