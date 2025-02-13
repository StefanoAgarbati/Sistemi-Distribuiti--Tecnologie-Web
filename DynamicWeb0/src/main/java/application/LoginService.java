package application;

import model.RegisteredUser;
import port.persistence.IRegisteredUserDao;

public class LoginService {
	
	private IRegisteredUserDao userDao;

	public LoginService(IRegisteredUserDao userDao) {
		this.userDao = userDao;
	}
	public RegisteredUser login(String username, String password) {
		RegisteredUser aUser = userDao.findByUsername(username);
		if(aUser.hasPassword(password))
			return aUser;
		return null;
	}
	
}
