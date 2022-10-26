package com.ludo.tutoriales.service;

import com.ludo.tutoriales.model.Role;

public interface RoleService {

	void save(Role role);

	long numUserRole(String username);

}
