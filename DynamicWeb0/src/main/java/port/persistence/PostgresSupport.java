package port.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresSupport {

	private String url = "jdbc:postgresql://address:port/dbname?props";
	
	private String host;
	private String port;
	private String dbName;
	private String props;
	
	private Connection connection = null;
	
	public PostgresSupport() {
		this("localhost", "5432", "Test", "user=postgres&password=1234");
	}
	public PostgresSupport(String host, String port, String dbname, String props) {
		this.host = host;
		this.port = port;
		this.dbName = dbname;
		this.props = props;
		this.connection = getConnection();
	}
	public Connection getConnection() {
		if(this.connection != null) {
			return this.connection;
		}
		String res = this.url
				.replace("address", host)
				.replace("port", port)
				.replace("dbname", dbName);
		if(props.equals("")) {
			res = res.replace("?props", "");
			
		} else {
			res = res.replace("props", props);
		}
		System.out.println(res);
		try {
			connection = DriverManager.getConnection(res);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Connection ["+connection+"]");
		return connection;
	}
	public void create(String createSql) throws Exception {
		Statement s = connection.createStatement();
		s.executeUpdate(createSql);
		s.close();
	}
	public ResultSet sendQuery(String sqlQuery) throws Exception {
		Statement s = connection.createStatement();
		return s.executeQuery(sqlQuery);
	}
	public Statement getStatement(Connection conn) throws Exception {
		return conn.createStatement();
	}
	
}
