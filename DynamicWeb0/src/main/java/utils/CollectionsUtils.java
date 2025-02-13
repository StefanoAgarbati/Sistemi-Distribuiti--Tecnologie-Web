package utils;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;


public class CollectionsUtils {

	public static <T> List<T> filter(Collection<T> collection, Predicate<T> pred) {
		List<T> list = new LinkedList<>();
		for(T item : collection) {
			if(pred.isSatisfied(item)) {
				list.add(item);
			}
		}
		return list;
				
	}
	public static <T> T filterOne(Collection<T> collection, Predicate<T> pred) {
		List<T> list = CollectionsUtils.filter(collection, pred);
		if(list.isEmpty())
			return null;
		return list.get(0);
	}
	public interface Predicate<T> {
		boolean isSatisfied(T t);
	}
	
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("genio");
		list.add("bekko");
		list.add("Gianni");
		List<String> elList = CollectionsUtils.filter(list, (item) -> item.contains("e"));
		
		OutUtils.out("element is null " + (elList==null ? "true" : "false"));
		OutUtils.out("list " + elList);
		System.out.println("String element: ");
	}
}
