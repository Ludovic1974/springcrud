package com.ludo.tutoriales.dao;

import com.ludo.tutoriales.model.User;

public interface UserDao extends ObjectDao {
	void delete(String username);

	User get(String username);
}
