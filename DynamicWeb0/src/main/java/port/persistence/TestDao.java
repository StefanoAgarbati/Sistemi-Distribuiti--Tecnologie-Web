package port.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.ITest;
import model.PossibleResponse;
import model.Question;
import model.Score;
import model.Test;

public class TestDao {

	private String createTest = "INSERT INTO TEST VALUES (ID,NAME)";

	
	public void create(Test aTest) {
		System.out.println("TestDao - test owner " + aTest.getOwner().getId());
		aTest.setId(IdGenerator.generateId());
		create(createTest(aTest.getOwner().getId(), aTest.id(), aTest.getName()));
	}
	
	public void createNewTest(String name) {
		create(createTest(IdGenerator.generateId(), name));
	}
	public Test read(String tid) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM test WHERE test.testid = '" + tid+"'");
			List<Question> questions = this.getQuestionsFromTest(tid);
			rs.next();
			Test t = new Test();
			t.setId(rs.getString(1));
			t.setName(rs.getString(2));
			t.setQuestions(questions);
			return t;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void create(String sql) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			s.executeUpdate(sql);
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private String createTest(String ownerId, String tid, String name) {
		String createTest = "INSERT INTO test VALUES (TID,NAME,OID)";
		createTest = createTest.replace("TID", "'"+tid+"'")
				.replace("NAME", "'"+name+"'")
				.replace("OID", "'"+ownerId+"'");
		return createTest;
	}
	private String createTest(String tid, String name) {
		String createTest = "INSERT INTO TEST VALUES (ID,NAME)";
		createTest = createTest.replace("ID", "'"+tid+"'").replace("NAME", "'"+name+"'");
		return createTest;
	}

	public void update(Test aTest) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			s.executeUpdate("UPDATE test SET testname = '" + aTest.getName() + "'");
			Collection<Question> testQuestions = aTest.getQuestions();
			for(Question q : testQuestions) {
				if(q.getId() == null) {
					
				}
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Collection<Test> getAllTestsByCategory(String categoryId) {
		return null;
	}
	public Collection<Test> findTestByOwner(String ownerId) {
		Connection conn = DbSupport.getConnection();
		Collection<Test> tests = new ArrayList<>();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(findTestByOwnerQuery(ownerId));
			while(rs.next()) {
				Test test = new TestProxy();
				test.setId(rs.getString(1));
				test.setName(rs.getString(2));
				tests.add(test);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tests;
	}
	private String findTestByOwnerQuery(String ownerId) {
		String sql = "SELECT testid, testname FROM test WHERE testowner=" +"'"+ownerId+"'";
		return sql;
	}
	private Question getQuestionFromId(String qid) {
		try {
			List<PossibleResponse> responses = this.getResponsesFromQuestion(qid);
			ResultSet rs = this.execQuery("SELECT * FROM question WHERE question.questionId = '" + qid+"'");
			rs.next();
			String questId = rs.getString(1);
			String text = rs.getString(2);
			int score = rs.getInt(3);
			Question q = new Question();
			q.setId(questId);
			q.setPossibleResponses(responses);
			q.setScore(new Score(0, -1, score));
			q.setText(text);
			return q;
		} catch (Exception e) {

		}
		return null;
	}

	private List<Question> getQuestionsFromTest(String tid) {
		try {
			List<Question> questions = new ArrayList<>();
			ResultSet rs = this.execQuery(
					"SELECT questionid FROM assigned_question " + "WHERE assigned_question.testId = '" + tid + "'");
			System.out.println("query executed -- fetch size " + rs.getFetchSize());
			while (rs.next()) {
				String qid = rs.getString(1);
				Question q = this.getQuestionFromId(qid);
				questions.add(q);
				System.out.println("cycle");
			}
			return questions;
		} catch (SQLException e) {
			System.out.println("Some error occurs");
			e.printStackTrace();
		}
		return null;
	}

	private List<PossibleResponse> getResponsesFromQuestion(String qid) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT * FROM possible_response WHERE possible_response.questionId = '" + qid + "'");
			System.out.println("Executed query");
			List<PossibleResponse> responses = new ArrayList<>();
			while (rs.next()) {
				String resId = rs.getString(2);
				boolean isCorrect = rs.getBoolean(3);
				String text = rs.getString(4);
				PossibleResponse pr = new PossibleResponse(resId, isCorrect, text);
				responses.add(pr);
			}
			s.close();
			return responses;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private ResultSet execQuery(String sql) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			//s.close();
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String createNewTestQuery() {
		
	}
	public static void main(String[] args) {
		TestDao tdao = new TestDao();
		Test test = tdao.read("1");
		System.out.println("Test name " + test.getName());
		test.getQuestions().stream().forEach(question -> {
			System.out.println("Question id " + question.getId());
			question.getPossibleResponses().stream().forEach(res -> {
				System.out.println("response " + res.getText());
			});
		});
		
	}
	public Test find(String testId) {
		return read(testId);
	}
}
