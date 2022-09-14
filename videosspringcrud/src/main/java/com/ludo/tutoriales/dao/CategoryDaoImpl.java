package com.ludo.tutoriales.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ludo.tutoriales.model.Category;

@Repository
public class CategoryDaoImpl implements ObjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<?> list() {
		String sentencia;
		TypedQuery<?> query;
		sentencia = "from Category c ORDER BY c.name";
		query = sessionFactory.getCurrentSession().createQuery(sentencia);
		return query.getResultList();
	}

	@Override
	public Long num() {

		return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Category").uniqueResult();

	}

	@Override
	public void save(Object category) {
		sessionFactory.getCurrentSession().saveOrUpdate(category);

	}

	@Override
	public void delete(long id) {
		Category savedCategoryEntity = sessionFactory.getCurrentSession().find(Category.class, id);
		sessionFactory.getCurrentSession().remove(savedCategoryEntity);

	}

	@Override
	public Object get(long id) {
		return sessionFactory.getCurrentSession().find(Category.class, id);
	}

}
