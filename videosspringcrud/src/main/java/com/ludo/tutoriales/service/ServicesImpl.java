package com.ludo.tutoriales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ludo.tutoriales.dao.BookDao;
import com.ludo.tutoriales.model.Book;
import com.ludo.tutoriales.other.Fecha;

@Service
public class ServicesImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional(readOnly = true)
	public List<?> listBooks() {
		// TODO Auto-generated method stub
		return bookDao.list();
	}

	@Override
	@Transactional
	public Long numBooks() {
		// TODO Auto-generated method stub
		return bookDao.num();
	}

	@Override
	@Transactional
	public void save(Book book) {
		if (book.getId() > 0) {
			// Actualizando un libro
			book.setUpdatedAt(Fecha.getTimeStamp());
		} else {
			// Creando un libro
			book.setUpdatedAt(Fecha.getTimeStamp());
			book.setCreatedAt(Fecha.getTimeStamp());
		}

		bookDao.save(book);
	}

	@Override
	@Transactional
	public void deleteBook(long id) {
		bookDao.delete(id);

	}

	@Override
	@Transactional
	public Book getBook(long id) {
		return bookDao.get(id);
	}

}
