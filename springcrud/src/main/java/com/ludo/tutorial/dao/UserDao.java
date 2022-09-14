package com.ludo.tutorial.dao;

public interface UserDao extends ObjectDao {

	void delete(String username);

	Object get(String username);
}
