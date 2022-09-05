package com.ludo.tutorial.dao;

import java.util.List;

import com.ludo.tutorial.model.Book;

public interface BookDao {
	List<?> list();

	long num();

	void save(Book book);

	void delete(long id);
}
