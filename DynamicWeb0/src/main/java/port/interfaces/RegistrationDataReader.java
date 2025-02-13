package port.interfaces;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import application.RegistrationData;

public class RegistrationDataReader {

	private String rep;
	private JsonObject jsonRep;
	
	public RegistrationDataReader(String rep) {
		this.rep = rep;
		jsonRep = getAsJsonObject(this.rep);
	}
	public static RegistrationDataReader create(String rep) {
		System.out.println("Registration data reader created");
		return new RegistrationDataReader(rep);
	}
	private JsonObject getAsJsonObject(String json) {
		JsonReader reader = Json.createReader(new StringReader(json));
		JsonObject data = reader.readObject();
		System.out.println("json object created");
		return data;
	}
	
	public RegistrationData getRegistrationData() {
		
		String username = getUsername();
		String password = getPassword();
		String firstname = getFirstname();
		String lastname = getLastname();
		String role = getRole();
		
		RegistrationData registrationData = RegistrationData.create(username, password, firstname, lastname, role);
		
		return registrationData;
	}
	
	private String getRole() {
		return jsonRep.getString("role");
	}
	private String getLastname() {
		return jsonRep.getString("lastname");
	}
	private String getFirstname() {
		return jsonRep.getString("firstname");
	}
	private String getPassword() {
		return jsonRep.getString("password");
	}
	public String getUsername() {
		return jsonRep.getString("username");
	}
}
