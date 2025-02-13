package useCases;

import java.util.Collection;

import model.Test;
import port.persistence.ITestRepository;

public class GetTestsFromOwner {

	private ITestRepository testRepository;
	
	public Collection<Test> execute(String ownerId) {
		return null;
	}
}
