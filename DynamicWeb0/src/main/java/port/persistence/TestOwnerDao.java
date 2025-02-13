package port.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import model.Test;
import model.TestOwner;

public class TestOwnerDao {

	private static final String TABLE = "test_owner";
	
	public void addTestOwner(TestOwner aTestOwner) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			int res = s.executeUpdate(addTestOwnerSql(aTestOwner.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteTestOwner(TestOwner aTestOwner) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			int res = s.executeUpdate(deleteTestOwnerSql(aTestOwner.getId()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private String deleteTestOwnerSql(String id) {
		return "delete from test_owner where testOwnerId = '"+id+"'";
	}
	public TestOwner find(String ownerId) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(findById(ownerId));
			while(rs.next()) {
				TestOwner to = new TestOwner();
				to.setId(ownerId);
				System.out.println("TestOwner id " + to.getId());
				return to;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void addTestToOwner(Test aTest, TestOwner anOwner) {
		Connection conn =DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			System.out.println("AddTestToOwner - tid " + aTest. + ", ownerId " + anOwner.getId());
			s.executeUpdate(this.insertTestForOwner(aTest.id(), anOwner.getId()));
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private String deleteSql(String table, String condition) {
		return "delete from " + table + "where " + condition;
	}
	private String addTestOwnerSql(String id) {
		String sql = "insert into test_owner values('id')";
		sql = sql.replace("id", id);
		return sql;
	}
	
	private String findById(String ownerId) {
		String sql = "SELECT * FROM test_owner WHERE testOwnerId='" + ownerId + "'";
		return sql;
	}
	private String insertTestForOwner(String tid, String oid) {
		String sql = "INSERT INTO test_owner VALUES (TID,OID)";
		sql = sql.replace("TID", "'"+ tid + "'")
				.replace("OID", "'"+oid+"'");
		System.out.println("Query insertTestForOwner " + sql);
		return sql;
	}

	private Connection getConnection() {
		return null;
	}

	public void update(TestOwner owner) {
		
	}

}
