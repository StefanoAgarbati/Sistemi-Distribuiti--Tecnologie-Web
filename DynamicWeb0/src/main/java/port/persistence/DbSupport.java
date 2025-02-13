package port.persistence;

import java.sql.Connection;

public class DbSupport {

	private static PostgresSupport postgres = new PostgresSupport("localhost", "5432", "Test", "user=postgres&password=1234");
	
	public static Connection getConnection() {
		return postgres.getConnection();
	}

}
