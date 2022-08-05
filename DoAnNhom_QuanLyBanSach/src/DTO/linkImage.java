package DTO;

public class linkImage {
	private String link;
	private String idBook;
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public linkImage(String link, String idBook) {
		
		this.link = link;
		this.idBook = idBook;
	}
	
}
