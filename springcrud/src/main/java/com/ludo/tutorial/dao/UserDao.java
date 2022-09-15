package com.ludo.tutorial.dao;

import javax.validation.Valid;

import com.ludo.tutorial.model.User;

public interface UserDao extends ObjectDao {

	void delete(String username);

	Object get(String username);

	void loanBooks(@Valid User user);
}
