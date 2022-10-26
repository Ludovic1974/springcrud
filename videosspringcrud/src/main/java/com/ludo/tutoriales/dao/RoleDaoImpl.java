package com.ludo.tutoriales.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ludo.tutoriales.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Role role) {
		sessionFactory.getCurrentSession().persist(role);

	}

	@Override
	public long numUserRole(String username) {
		long result = 0;
		String sentencia = "SELECT COUNT(*) FROM Role role WHERE role.user.username = :username";
		result = ((long) sessionFactory.getCurrentSession().createQuery(sentencia).setParameter("username", username)
				.uniqueResult());
		return result;
	}

}
