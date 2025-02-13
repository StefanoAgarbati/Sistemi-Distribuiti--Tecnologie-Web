package port.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.RegisteredUser;
import model.UserRole;

public class RegisteredUserDao implements IRegisteredUserDao {

	private String table = "users";
	
	@Override
	public RegisteredUser findByUsername(String username) {
		System.out.println("findByUsername");
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(findUser(username));
			System.out.println("ResultSet is null"+rs==null);
			RegisteredUser user = createUserFromRs(rs);
			rs.close();
			s.close();
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	private RegisteredUser createUserFromRs(ResultSet rs) throws SQLException {
		boolean next = rs.next();
		if(next) {
			String username = rs.getString(1);
			String password = rs.getString(2);
			String firstname = rs.getString(3);
			String lastname = rs.getString(4);
			UserRole role = new UserRole(rs.getString(5));
			RegisteredUser user = new RegisteredUser(username, password, firstname, lastname, role);
			System.out.println("User " + user);
			return user;
		}
		return null;
	}
	@Override
	public boolean registerNewUser(RegisteredUser registeredUser){
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			s.executeUpdate(insertUser(registeredUser.getUsername(),registeredUser.getPassword(),
					registeredUser.getFirstname(), registeredUser.getLastname(),registeredUser.getRole().getName()));
			s.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean removeRegisteredUser(RegisteredUser aUser) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			s.executeUpdate(deleteUser(aUser.getUsername()));
			s.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean changeUserPassword(String username, String newPassword) {
		Connection conn = DbSupport.getConnection();
		try {
			Statement s = conn.createStatement();
			s.executeUpdate(updatePassword(username,newPassword));
			s.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	private String findUser(String username) {
		String sql = "SELECT * FROM users WHERE username=UNAME";
		sql = sql.replace("UNAME", "'"+username+"'");
		return sql;
	}
	private String updatePassword(String username, String password) {
		String sql = "UPDATE users SET password=PASS WHERE username=UNAME";
		sql=sql.replace("PASS", "'"+password+"'")
				.replace("UNAME", "'"+username+"'");
		return sql;
	}
	private String deleteUser(String username) {
		String sql = "DELETE FROM users WHERE username='"+username+"'";
		return sql;
	}
	private String insertUser(String username, String password, String firstname, String lastname,String roleName) {
		String sql = "INSERT INTO users VALUES (username,password,firstname,lastname,role)";
		sql = sql.replace("username", "'"+username+"'")
				.replace("password", "'"+password+"'")
				.replace("firstname", "'"+firstname+"'")
				.replace("lastname", "'"+lastname+"'")
				.replace("role", "'"+roleName+"'");
		return sql;
	}
	
	public static void main(String[] args) {
		RegisteredUserDao dao = new RegisteredUserDao();
		RegisteredUser user = new RegisteredUser("stefanone","12345abcd","Stefano","Agarbati",new UserRole("educator"));
		boolean res = dao.registerNewUser(user);
		
		user = dao.findByUsername("stefanone");
		System.out.println(user.getStringRep());
		
		
	}
}
