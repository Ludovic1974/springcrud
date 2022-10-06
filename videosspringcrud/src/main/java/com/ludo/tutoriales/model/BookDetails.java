package com.ludo.tutoriales.model;

import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.PastOrPresent;

@Entity
@Table(name = "book_details")
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;

	@PastOrPresent(message = "{book.year.invalid}")
	@Column(name = "publication_year")
	private Year publicationYear;

	@PastOrPresent(message = "{book.year.invalid}")
	@Column(name = "purchase_year")
	private Year purchaseYear;

	@Column(name = "page_number")
	@Digits(integer = 4, fraction = 0, message = "{book.digits.invalid}")
	@Min(value = 20, message = "{book.page_number_min.invalid}")
	@Max(value = 5000, message = "{book.page_number_max.invalid}")
	private String pageNumber;

	// RELACION 1A1
	@OneToOne
	@JoinColumn(name = "id")
	private Book book;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	// FIN RELACION 1A1

	public BookDetails() {

	}

	public BookDetails(long id, Year publicationYear, Year purchaseYear, String pageNumber) {
		this.id = id;
		this.publicationYear = publicationYear;
		this.purchaseYear = purchaseYear;
		this.pageNumber = pageNumber;
	}

	public BookDetails(Year publicationYear, Year purchaseYear, String pageNumber) {
		this.publicationYear = publicationYear;
		this.purchaseYear = purchaseYear;
		this.pageNumber = pageNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Year getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Year publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Year getPurchaseYear() {
		return purchaseYear;
	}

	public void setPurchaseYear(Year purchaseYear) {
		this.purchaseYear = purchaseYear;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return String.format(
				"BookDetails [getId()=%s, getPublicationYear()=%s, getPurchaseYear()=%s, getPageNumber()=%s]", getId(),
				getPublicationYear(), getPurchaseYear(), getPageNumber());
	}

}
