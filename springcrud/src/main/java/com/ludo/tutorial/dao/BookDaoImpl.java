package com.ludo.tutorial.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ludo.tutorial.model.Book;

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

	@Override
	public long num() {
		long count = ((long) sessionFactory.getCurrentSession().createQuery("SELECT COUNT(*) FROM Book")
				.uniqueResult());
		return count;
	}

	@Override
	public void save(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
	}

	@Override
	public void delete(long id) {
		Book savedBookEntity = sessionFactory.getCurrentSession().find(Book.class, id);
		sessionFactory.getCurrentSession().remove(savedBookEntity);

	}

	@Override
	public Book get(long id) {
		Session session = sessionFactory.getCurrentSession();
		Book book = session.get(Book.class, id);
		return book;
	}

}
