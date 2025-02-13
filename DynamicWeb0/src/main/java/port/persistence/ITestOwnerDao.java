package port.persistence;

import model.TestOwner;

public interface ITestOwnerDao {

	boolean addNewTestOwner(TestOwner aTestOwner);

	boolean deleteTestOwner(String id);

	TestOwner getOwnerByUsername(String username);

	TestOwner getOwnerById(String id);
}
