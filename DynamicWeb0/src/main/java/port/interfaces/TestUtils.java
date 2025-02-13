package port.interfaces;

import java.io.StringWriter;
import java.util.Collection;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import model.Test;

public class TestUtils {

	public static String serialize(Collection<Test> aCollection) {
		JsonObjectBuilder modelBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		aCollection.forEach(test -> {
			arrayBuilder.add(Json.createObjectBuilder()
					.add("id", test.id())
					.add("name", test.getName()));
		});
		JsonObject model = modelBuilder.add("tests", arrayBuilder).build();
		return jsonFromModel(model);
		
	}
	private static String jsonFromModel(JsonObject model) {
		StringWriter sw = new StringWriter();
		JsonWriter jw = Json.createWriter(sw);
		jw.writeObject(model);
		jw.close();
		return sw.toString();
	}
	public static String serialize(Test aTest) {
		JsonObject model = Json.createObjectBuilder()
				.add("id", aTest.id())
				.add("name", aTest.getName())
				.build();
		return jsonFromModel(model);
	}
}
