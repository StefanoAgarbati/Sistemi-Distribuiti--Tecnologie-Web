package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import utils.CollectionsUtils;
import utils.CollectionsUtils.Predicate;

public class InMemoryDao<T> {

	private Collection<T> items = new LinkedList<>();
	
	protected Collection<T> filter(Predicate<T> pred) {
		return CollectionsUtils.filter(items, pred);
	}
	
}
