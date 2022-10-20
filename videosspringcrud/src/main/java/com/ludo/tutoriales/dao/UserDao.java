package com.ludo.tutoriales.dao;

import java.util.List;

import com.ludo.tutoriales.model.User;

public interface UserDao extends ObjectDao {
	void delete(String username);

	User get(String username);

	void loanBooks(User user);

	User getWithBooks(String username);

	List<?> listWithBooks();

	List<?> findByEmail(String email);
}
