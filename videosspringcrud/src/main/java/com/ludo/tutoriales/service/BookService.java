package com.ludo.tutoriales.service;

import java.util.List;

import com.ludo.tutoriales.model.Book;

public interface BookService {

	List<?> listBooks();

	Long numBooks();

	void save(Book book);

	void deleteBook(long id);

	Book getBook(long id);

}
