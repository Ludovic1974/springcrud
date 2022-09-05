package com.ludo.tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ludo.tutorial.dao.BookDao;

@Service
public class ServicesImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Override
	@Transactional(readOnly = true)
	public List<?> listBooks() {
		return bookDao.list();
	}

	@Override
	@Transactional
	public long numBooks() {
		return bookDao.num();
	}

}
