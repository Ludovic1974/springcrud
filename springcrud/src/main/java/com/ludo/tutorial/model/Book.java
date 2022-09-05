package com.ludo.tutorial.model;

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
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(name = "title")
	@Size(max = 225, min = 1, message = "{book.title.invalid}")
	@NotEmpty(message = "{book.value.required}")
	private String title;

	@Column(name = "author")
	@Size(max = 225, min = 1, message = "{book.author.invalid}")
	@NotEmpty(message = "{book.value.required}")
	private String author;

	public Book() {

	}

	public Book(long id,
			@Size(max = 225, min = 1, message = "{book.title.invalid}") @NotEmpty(message = "{book.value.required}") String title,
			@Size(max = 225, min = 1, message = "{book.author.invalid}") @NotEmpty(message = "{book.value.required}") String author) {
		this.id = id;
		this.title = title;
		this.author = author;
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
		return String.format("Book [getId()=%s, getTitle()=%s, getAuthor()=%s]", getId(), getTitle(), getAuthor());
	}

}
