package DTO;

public class typeBook {
	private String idTypeBook;
	private String nameTypeBook;
	private String status;
	public typeBook(String idTypeBook, String nameTypeBook, String status) {
		super();
		this.idTypeBook = idTypeBook;
		this.nameTypeBook = nameTypeBook;
		this.status = status;
	}
	public String getIdTypeBook() {
		return idTypeBook;
	}
	public void setIdTypeBook(String idTypeBook) {
		this.idTypeBook = idTypeBook;
	}
	public String getNameTypeBook() {
		return nameTypeBook;
	}
	public void setNameTypeBook(String nameTypeBook) {
		this.nameTypeBook = nameTypeBook;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
