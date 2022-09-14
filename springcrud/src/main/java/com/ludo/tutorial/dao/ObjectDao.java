package com.ludo.tutorial.dao;

import java.util.List;

public interface ObjectDao {
	List<?> list();

	long num();

	void save(Object obj);

	void delete(long id);

	Object get(long id);
}
