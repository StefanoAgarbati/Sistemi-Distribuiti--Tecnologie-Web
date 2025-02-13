package port.persistence;

import java.util.Collection;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;

import model.Test;
import model.TestRepository;

import java.util.*;

public class MongoTestRepository implements TestRepository {
	
	private String dbUri = "mongodb://localhost:27017";
	private String dbName = "testdb";
	private MongoCollection<Document> testCollection; 
	
	@Override
	public Test findTestById(String testId) {
		Test test = null;
		Document doc = testCollection.find(Filters.eq("testId", testId)).first();
		if(doc != null) {
			test = new Test();
			test.setId(doc.getString("id"));
			test.setName(doc.getString("name"));
		}
		return test;
	}

	@Override
	public void save(Test aTest) {
		if(aTest.id()==null) {
			insert(aTest);
		} else {
			update(aTest);
		}
		this.testCollection.insertOne(new Document()
				.append("name", aTest.getName())
				.append(dbName, aTest));
	}

	@Override
	public Collection<Test> getAllTests() {
		return null;
	}

	@Override
	public long nextId() {
		return 0;
	}
	private String generateId() {
		return IdGenerator.generateId();
	}
	private void update(Test aTest) {
		
	}
	private void insert(Test aTest) {
		Document testDoc = new Document()
				.append("name", aTest.getName());
		InsertOneResult res = this.testCollection.insertOne(testDoc);
	}
	private void connectToDb(String uri) {
		MongoClient client = MongoClients.create(uri);
		MongoDatabase db = client.getDatabase(dbName);
		this.testCollection = db.getCollection("TEST");
	}
	

}
