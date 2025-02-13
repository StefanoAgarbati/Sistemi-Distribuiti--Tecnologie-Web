package port.persistence;

import model.RegisteredUser;

public interface IRegisteredUserDao {

	RegisteredUser findByUsername(String username);
	
	RegisteredUser findById(String userId);

	boolean registerNewUser(RegisteredUser registeredUser);

	boolean removeRegisteredUser(RegisteredUser aUser);

	boolean changeUserPassword(String username, String newPassword);

}