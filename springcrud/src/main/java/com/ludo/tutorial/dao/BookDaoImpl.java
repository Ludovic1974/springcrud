package com.ludo.tutorial.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImpl implements BookDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<?> list() {
		String sentencia;
		TypedQuery<?> query;
		sentencia = "from Book b ORDER BY b.title";
		System.out.println(sentencia);
		query = sessionFactory.getCurrentSession().createQuery(sentencia);
		return query.getResultList();
	}

}
