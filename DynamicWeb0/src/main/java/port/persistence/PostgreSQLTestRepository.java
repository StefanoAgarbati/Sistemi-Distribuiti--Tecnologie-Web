package port.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.List;

import model.Question;
import model.Test;
import model.TestRepository;

public class PostgreSQLTestRepository implements TestRepository {
	
	private PostgresSupport support = new PostgresSupport("localhost", "5432", "Test", "user=postgres&password=1234");
	public PostgreSQLTestRepository() {
	}
	
	@Override
	public Test findTestById(String testId) {
		Test test = null;
		try {
			ResultSet rs = support.sendQuery("select * from test where testId = " + testId);
			rs.next();
			test = new Test();
			test.setId(rs.getString(1));
			test.setName(rs.getString(2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return test;
	}

	@Override
	public void save(Test aTest) {
		if(aTest.id() == null) {
			create(aTest);
		} else {
			update(aTest);
		}
	}

	private void update(Test aTest) { 
		
	}

	private void create(Test aTest) {
		aTest.setId(IdGenerator.generateId());
		try {
			support.create(insertInto("test", "testID,name", ""+aTest.id() + ","+aTest.getName()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Collection<Test> getAllTests() {
		return null;
	}

	@Override
	public long nextId() {
		return 0;
	}
	
	private String insertInto(String table, String cols, String values) {
		String insert = "INSERT INTO TABLE (COLS) VALUES (VALS);";
		insert = insert.replace("COLS", cols)
				.replace("VALS", values);
		return insert;
	}
	private List<Question> listQuestions(String testId) {
		return null;
	}
	
}
