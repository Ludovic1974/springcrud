package com.ludo.tutoriales.dao;

public interface UserDao extends ObjectDao {
	void delete(String username);

	Object get(String username);
}
