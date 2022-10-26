package com.ludo.tutoriales.dao;

import java.util.List;

import com.ludo.tutoriales.model.User;

public interface UserDao extends ObjectDao {
	void delete(String username);

	User get(String username);

	User getUserWithRoles(String username);

	User getWithBooks(String username);

	void loanBooks(User user);

	List<?> listWithBooks();

	List<?> findByEmail(Object email);

}
