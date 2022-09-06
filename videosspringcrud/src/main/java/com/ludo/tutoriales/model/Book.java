package com.ludo.tutoriales.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
