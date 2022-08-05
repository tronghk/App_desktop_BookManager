package DTO;

import java.time.LocalDate;

public class book {
	private String idBook;
	private String nameBook;
	private float unitPrice;
	private LocalDate datePublishing;
	private int quantityBook;
	private String idTypeBook;
	private String idPublishingCompany;
	private String status;
	public book(String idBook, String nameBook, float unitPrice, LocalDate datePublishing, int quantityBook,
			String idTypeBook, String idPublishingCompany, String status) {
		super();
		this.idBook = idBook;
		this.nameBook = nameBook;
		this.unitPrice = unitPrice;
		this.datePublishing = datePublishing;
		this.quantityBook = quantityBook;
		this.idTypeBook = idTypeBook;
		this.idPublishingCompany = idPublishingCompany;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public String getNameBook() {
		return nameBook;
	}
	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	public LocalDate getDatePublishing() {
		return datePublishing;
	}
	public void setDatePublishing(LocalDate datePublishing) {
		this.datePublishing = datePublishing;
	}
	public int getQuantityBook() {
		return quantityBook;
	}
	public void setQuantityBook(int quantityBook) {
		this.quantityBook = quantityBook;
	}
	public String getIdTypeBook() {
		return idTypeBook;
	}
	public void setIdTypeBook(String idTypeBook) {
		this.idTypeBook = idTypeBook;
	}
	public String getIdPublishingCompany() {
		return idPublishingCompany;
	}
	public void setIdPublishingCompany(String idPublishingCompany) {
		this.idPublishingCompany = idPublishingCompany;
	}
	
}
