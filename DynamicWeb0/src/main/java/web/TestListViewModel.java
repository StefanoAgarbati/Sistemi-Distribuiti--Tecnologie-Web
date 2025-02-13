package web;

import java.util.ArrayList;
import java.util.List;

public class TestListViewModel {

	private List<TestViewModel> tests;
	
	public TestListViewModel() {
		tests = new ArrayList<>();
		init();
	}
	
	private void init() {
		for(int i = 0; i < 10; i++) {
			TestViewModel tvm = new TestViewModel(i, "TestName"+i, i);
			tests.add(tvm);
		}
	}
	public List<TestViewModel> getTests() {
		return tests;
	}
}
