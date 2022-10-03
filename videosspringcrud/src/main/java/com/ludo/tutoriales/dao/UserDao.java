package com.ludo.tutoriales.dao;

import javax.validation.Valid;

import com.ludo.tutoriales.model.User;

public interface UserDao extends ObjectDao {
	void delete(String username);

	User get(String username);

	void loanBooks(@Valid User user);

	User getWithBooks(String username);
}
