package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Category;

public class TestForTest {
 
	@Test
	void canAddNewTest() {
		model.Test t = new model.Test();
		t.setName("testname");
		t.setCategory(new Category("generic"));
		model.Test res = testService.addNewTest(test);
		
		res = testRepo.findById(res.id());
		
		assertTrue(res!=null);
		assertTrue(res.getName().equals("testname"));
	}
}
