package BUS;

import java.util.ArrayList;

import DAO.linkImageDAO;
import DTO.linkImage;

public class linkImageBUS {
	linkImageDAO linkDAO;
	ArrayList<linkImage> arrLink;
	public linkImageBUS() {
		arrLink = new ArrayList<linkImage>();
		this.setLinkDAO(new linkImageDAO());
		arrLink = this.getLinkDAO().readLinkImage();
	}
	public linkImageDAO getLinkDAO() {
		return linkDAO;
	}
	public void setLinkDAO(linkImageDAO linkDAO) {
		this.linkDAO = linkDAO;
	}
	public linkImage returnLink(linkImage link) {
		link.setLink(link.getLink().replace("\\", "-"));
		return link;
	}
	public void createLink(String idBook, String link) {
		linkImage l = new linkImage(link, idBook);
		l.setLink(l.getLink().replace("\\", "-"));
		arrLink.add(l);
		
		this.getLinkDAO().addObject(l);
	}
	public String getLink(String idBook) {
		for(linkImage value: arrLink) {
			if(value.getIdBook().compareTo(idBook) == 0)
				return value.getLink();
		}
		return null;
	}
	public void modifyLink(linkImage link) {
		for(linkImage value: arrLink) {
			if(value.getIdBook().compareTo(link.getIdBook()) == 0) {
				value.setLink(link.getLink());
				break;
			}
			
		}
		this.getLinkDAO().modifyObject(returnLink(link));
	}
	public void deleteLinkObject(linkImage link) {
		int i=0;
		for(linkImage value: arrLink) {
			if(value.getIdBook().compareTo(link.getLink()) == 0) {
				arrLink.remove(arrLink.get(i));
				break;
			}
			i++;
		}
		this.getLinkDAO().deleteObject(link);
	}
	public String returnLink(String idBook) {
		for(linkImage value: arrLink)
			if(value.getIdBook().compareTo(idBook) == 0)
				return value.getLink();
		return "";	}
	
}
