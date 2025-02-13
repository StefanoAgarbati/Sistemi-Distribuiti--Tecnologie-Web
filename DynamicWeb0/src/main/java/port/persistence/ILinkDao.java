package port.persistence;


import model.Link;


public interface ILinkDao {

	boolean addNewLink(Link aLink);

	Link getLinkById(String linkId);
	
}
