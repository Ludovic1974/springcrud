package com.ludo.tutoriales.dao;

import java.util.List;

import com.ludo.tutoriales.model.Book;

public interface BookDao {
	List<?> list();

	Long num();

	void save(Book book);

	void delete(long id);

	Book get(long id);
}
