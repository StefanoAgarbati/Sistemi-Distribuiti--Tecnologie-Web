package port.persistence;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import model.Test;
import model.TestRepository;

public class InMemoryTestRepository implements TestRepository {

	private Map<String, Test> repo =  new HashMap<>();
	private static InMemoryTestRepository instance = null;
	private long nextId= 0;
	
	//Singleton
	public static InMemoryTestRepository create() {
		if(instance==null) {
			instance = new InMemoryTestRepository();
		}
		return instance;
	}
	public InMemoryTestRepository() {
		
	}
	@Override
	public Test findTestById(String testId) {
		return repo.get(testId);
	}

	@Override
	public void save(Test aTest) {
		if(aTest.id()==null) {
			insert(aTest);
		} else {
			update(aTest);
		}
		System.out.println("test saved " + repo.size());
		System.out.println(this.repo.toString());
	}
	
	private void update(Test aTest) {
		repo.put(aTest.id(), aTest);
	}
	private void insert(Test aTest) {
		aTest.setId(""+nextId());
		updateNextId();
		repo.put(aTest.id(), aTest);
	}
	private void updateNextId() {
		this.nextId++;
	}
	@Override
	public Collection<Test> getAllTests() {
		return repo.values();
	}
	
	public static void main(String[] args) {
		TestRepository tr = new InMemoryTestRepository();
		System.out.println(tr.getAllTests()==null);	
	}
	
	@Override
	public long nextId() {
		return nextId;
	}

}
