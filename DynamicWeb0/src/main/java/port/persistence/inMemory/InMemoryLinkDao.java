package port.persistence.inMemory;

import java.util.Collection;
import java.util.LinkedList;

import model.Link;
import port.persistence.ILinkDao;
import utils.CollectionsUtils;

public class InMemoryLinkDao implements ILinkDao {

	private Collection<Link> links = new LinkedList<>();
	
	@Override
	public Link getLinkById(String linkId) {
		return CollectionsUtils.filterOne(links, link -> link.getLinkId().equals(linkId));
		
	}

	@Override
	public boolean addNewLink(Link aLink) {
		return links.add(aLink);
	}

	
}
