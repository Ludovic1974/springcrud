package com.ludo.tutoriales.service;

import java.util.List;

import javax.validation.Valid;

import com.ludo.tutoriales.model.User;

public interface UserService {

	List<?> listUsers();

	Long numUsers();

	void save(@Valid User user);

	void deleteUser(String username);

	User getUser(String username);

}
