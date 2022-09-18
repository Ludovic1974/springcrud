package com.ludo.tutorial.dao;

import java.util.List;

import javax.validation.Valid;

import com.ludo.tutorial.model.User;

public interface UserDao extends ObjectDao {

	List<?> findByEmail(@Valid String email);

	void delete(String username);

	Object get(String username);

	void loanBooks(@Valid User user);

	Object getWithBooks(String username);

}
