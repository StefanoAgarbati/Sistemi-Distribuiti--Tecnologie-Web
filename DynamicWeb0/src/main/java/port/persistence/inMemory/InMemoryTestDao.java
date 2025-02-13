package port.persistence.inMemory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Test;
import port.persistence.ITestDao;
import utils.OutUtils;

public class InMemoryTestDao implements ITestDao {

	
	private Collection<Test> tests = new ArrayList<>();

	
	public InMemoryTestDao() {
		super();
		init();
	}

	@Override
	public Test getTestById(String testId) {
		for(Test t : tests) {
			if(t.getId().equals(testId))
				return t;
		}
		return null;
	}

	@Override
	public Collection<Test> getAllTestsByOwner(String ownerId) {
		List<Test> list = new ArrayList<>();
		for(Test t : tests) {
			if(t.getOwnerId().equals(ownerId))
				list.add(t);
		}
		return list;
	}

	@Override
	public void create(Test aTest) {
		tests.add(aTest);
		OutUtils.out("InMemoryTestDao-create " + aTest);
	}

	@Override
	public Collection<Test> getAllTestsByCategory(String categoryId) {
		List<Test> list = new ArrayList<>();
		for(Test test : tests) {
			if(test.getCategoryId().equals(categoryId)) {
				list.add(test);
			}
		}
		return list;
	}

	private void init() {
		Test t0 = Test.create("1", "Test1", "1", "1");
		Test t1 = Test.create("2", "Test2", "1", "1");
		Test t2 = Test.create("3", "Test3", "1", "1");
		Test t3 = Test.create("4", "Test4", "1", "1");
		this.tests.add(t0);
		this.tests.add(t1);
		this.tests.add(t2);
		this.tests.add(t3);
	}
	

}
