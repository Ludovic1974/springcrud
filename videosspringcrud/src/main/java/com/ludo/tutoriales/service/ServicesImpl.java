package com.ludo.tutoriales.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ludo.tutoriales.dao.LibraryDao;
import com.ludo.tutoriales.model.Book;
import com.ludo.tutoriales.model.Category;
import com.ludo.tutoriales.other.Fecha;

@Service
public class ServicesImpl implements BookService, CategoryService {

	@Autowired
	@Qualifier("bookDaoImpl")
	private LibraryDao bookDao;

	@Autowired
	@Qualifier("categoryDaoImpl")
	private LibraryDao categoryDao;

	@Override
	@Transactional(readOnly = true)
	public List<?> listBooks() {
		return bookDao.list();
	}

	@Override
	@Transactional
	public Long numBooks() {
		return bookDao.num();
	}

	@Override
	@Transactional
	public void save(Book book) {
		if (book.getId() > 0) {
			System.out.println("Actu de libro");
			book.setUpdatedAt(Fecha.getTimeStamp());
		} else {
			System.out.println("Creación de libro");
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
		Book book = (Book) bookDao.get(id);
		return book;
	}

	@Override
	@Transactional(readOnly = true)
	public List<?> listCategories() {
		return categoryDao.list();
	}

	@Override
	@Transactional
	public Long numCategories() {
		return categoryDao.num();
	}

	@Override
	@Transactional
	public void save(@Valid Category category) {
		if (category.getId() > 0) {
			System.out.println("Actu de categoría");
			category.setUpdatedAt(Fecha.getTimeStamp());
		} else {
			System.out.println("Creación de categoría");
			category.setUpdatedAt(Fecha.getTimeStamp());
			category.setCreatedAt(Fecha.getTimeStamp());
		}
		categoryDao.save(category);

	}

	@Override
	@Transactional
	public void deleteCategory(long id) {
		categoryDao.delete(id);

	}

	@Override
	@Transactional
	public Category getCategory(long id) {
		// TODO Auto-generated method stub
		return (Category) categoryDao.get(id);
	}

}
