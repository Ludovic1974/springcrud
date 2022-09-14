package com.ludo.tutorial.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ludo.tutorial.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Object user) {
		if (get(((User) user).getUsername()) == null) {
			sessionFactory.getCurrentSession().persist(user);
		} else {
			sessionFactory.getCurrentSession().merge(user);
		}

	}

	@Override
	public List<?> list() {
		String sentencia;
		TypedQuery<?> query;
		sentencia = "from User u ORDER BY u.username";
		query = sessionFactory.getCurrentSession().createQuery(sentencia);
		return query.getResultList();
	}

	@Override
	public void delete(String username) {
		User savedUserEntity = sessionFactory.getCurrentSession().find(User.class, username);
		sessionFactory.getCurrentSession().remove(savedUserEntity);

	}

	@Override
	public User get(String username) {
		User user = sessionFactory.getCurrentSession().find(User.class, username);
		return user;
	}

	@Override
	public long num() {
		return ((long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM User").uniqueResult());

	}

}
