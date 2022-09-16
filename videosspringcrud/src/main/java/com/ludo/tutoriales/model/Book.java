package com.ludo.tutoriales.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
public class Book extends DateColumns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	@Size(max = 225, min = 1, message = "{book.title.invalid}")
	@NotEmpty(message = "{book.title.required}")
	private String title;
	@Column
	@Size(max = 225, min = 1, message = "{book.author.invalid}")
	@NotEmpty(message = "{book.author.required}")
	private String author;

	// RELACION 1A1 CON BOOKDETAILS
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "book", fetch = FetchType.LAZY)
	@Valid
	private BookDetails bookDetails;

	public BookDetails getBookDetails() {
		return bookDetails;
	}

	public void setBookDetails(BookDetails bookDetails) {
		this.bookDetails = bookDetails;
	}
	// FIN RELACION 1A1 CON BOOKDETAILS

	// RELACION 1AVS CON CATEGORY
	@ManyToOne
	@JoinColumn(name = "cat_id")
	@Valid
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// FIN RELACION 1AVS CON CATEGORY

	public Book(Date createdAt, Date updatedAt, long id,
			@Size(max = 225, min = 1, message = "{book.title.invalid}") @NotEmpty(message = "{book.title.required}") String title,
			@Size(max = 225, min = 1, message = "{book.author.invalid}") @NotEmpty(message = "{book.author.required}") String author) {
		super(createdAt, updatedAt);
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public Book(Date createdAt, Date updatedAt,
			@Size(max = 225, min = 1, message = "{book.title.invalid}") @NotEmpty(message = "{book.title.required}") String title,
			@Size(max = 225, min = 1, message = "{book.author.invalid}") @NotEmpty(message = "{book.author.required}") String author) {
		super(createdAt, updatedAt);
		this.title = title;
		this.author = author;
	}

	public Book(Date createdAt, Date updatedAt) {
		super(createdAt, updatedAt);
	}

	public Book() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return String.format("Book [getId()=%s, getTitle()=%s, getAuthor()=%s, getCreatedAt()=%s, getUpdatedAt()=%s]",
				getId(), getTitle(), getAuthor());
	}

}
