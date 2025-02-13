package test;

import java.util.ArrayList;
import java.util.List;

public class TestString {

	public static void main(String[] args) {
		String s = "     Stefano, Agarbati, ffff, aaaa     ";
		s = s.replace(" ", "");
		System.out.println(s);
		
		printListTest();
	}
	
	private static void printListTest() {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		System.out.println("List: " + list);
	}
}
