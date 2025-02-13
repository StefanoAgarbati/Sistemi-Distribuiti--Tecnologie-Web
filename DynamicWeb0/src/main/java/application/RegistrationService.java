package application;

import model.Category;
import model.RegisteredUser;
import model.Role;
import model.TestOwner;
import port.persistence.ICategoryDao;
import port.persistence.IRegisteredUserDao;
import port.persistence.ITestOwnerDao;
import port.persistence.IdGenerator;

public class RegistrationService {

	private IRegisteredUserDao userDao; 
	private ITestOwnerDao testOwnerDao;
	private ICategoryDao categoryDao;
	//private IRoleDao roleDao;
	
	public RegistrationService(IRegisteredUserDao userDao, ITestOwnerDao testOwnerDao, ICategoryDao categoryDao) {
		this.userDao = userDao;
		this.testOwnerDao = testOwnerDao;
		this.categoryDao = categoryDao;
	}

	public boolean registerNewUser(String role, String username, String password, String firstname, String lastname) {
		RegisteredUser aUser = userDao.findByUsername(username);
		if(aUser != null)
			return false;
		aUser = RegisteredUser.create(IdGenerator.generateId(),username, password, firstname, lastname, role);
		boolean isRegistered = userDao.registerNewUser(aUser);
		if(role.equals(Role.educator)) {
			TestOwner aTestOwner = TestOwner.create(IdGenerator.generateId(), aUser.getUserId());
			boolean isTestOwnerCreated = testOwnerDao.addNewTestOwner(aTestOwner);
			boolean isCategoryCreated = this.categoryDao.createNewcategory(Category.create(IdGenerator.generateId(), "Generic", aTestOwner.getId()));
			return isRegistered && isTestOwnerCreated && isCategoryCreated;
		}
		return isRegistered;
		
	}
	
	public RegisteredUser getUserByUsername(String username) {
		return this.userDao.findByUsername(username);
	}
	public RegisteredUser getUserById(String userId) {
		RegisteredUser aUser = this.userDao.findByUsername(userId);
		return aUser;
	}
	public RegisteredUser getUserByIdentifier(String userId) {
		return this.userDao.findById(userId);
	}
	
}
