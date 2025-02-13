package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresExp {

	private String url = "jdbc:dbms://address:port/dbname?props";
	
	public Connection getConnection(String dbms, String host, String port, String dbname, String props) {
		String res = this.url.replace("dbms", dbms)
				.replace("address", host)
				.replace("port", port)
				.replace("dbname", dbname);
		if(props.equals("")) {
			res = res.replace("?props", "");
			
		} else {
			res = res.replace("props", props);
		}
		System.out.println(res);
		Connection connection;
		try {
			connection = DriverManager.getConnection(res);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Statement getStatement(Connection conn) throws Exception {
		return conn.createStatement();
	}
	
	public static void main(String[]args) throws Exception {
		PostgresExp pe = new PostgresExp();
		Connection c = pe.getConnection("postgresql", "localhost", "5432", "Test", "user=postgres&password=1234");
		Statement s = pe.getStatement(c);
		ResultSet res = s.executeQuery("select * from test");
		while(res.next()) {
			System.out.print(res.getString(1));
			System.out.print(" ");
			System.out.print(res.getString(2));
			System.out.println();
		}
		
	}
}
