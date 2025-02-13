package port.persistence;

import model.UserRole;

public interface IRoleDao {

	UserRole getRoleById(String roleId);

}