package com.ludo.tutoriales.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ludo.tutoriales.model.Book;

@Repository
public class BookDaoImpl implements ObjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<?> list() {
		String sentencia;
		TypedQuery<?> query;
		sentencia = "from Book b ORDER BY b.title";
		query = sessionFactory.getCurrentSession().createQuery(sentencia);
		return query.getResultList();

	}

	@Override
	public Long num() {
		// TODO Auto-generated method stub
		return (Long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Book").uniqueResult();
	}

	@Override
	public void save(Object book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);

	}

	@Override
	public void delete(long id) {
		Book savedBookEntity = sessionFactory.getCurrentSession().find(Book.class, id);
		sessionFactory.getCurrentSession().remove(savedBookEntity);

	}

	@Override
	public Book get(long id) {
		return sessionFactory.getCurrentSession().find(Book.class, id);

	}

}
