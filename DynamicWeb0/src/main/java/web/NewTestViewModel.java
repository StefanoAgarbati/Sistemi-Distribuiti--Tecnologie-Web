package web;

import java.util.ArrayList;
import java.util.List;

public class NewTestViewModel {

	private List<CategoryViewModel> categories;
	
	public NewTestViewModel() {
		init();
		
	}
	private void init() {
		categories = new ArrayList<>();
		categories.add(new CategoryViewModel("Generic", "0"));
		categories.add(new CategoryViewModel("Physics", "1"));
		categories.add(new CategoryViewModel("Math", "2"));
		categories.add(new CategoryViewModel("Computer Engineering", "3"));
		categories.add(new CategoryViewModel("Salcicciona", "4"));
	}
	public List<CategoryViewModel> getCategories() {
		return categories;
	}
}
