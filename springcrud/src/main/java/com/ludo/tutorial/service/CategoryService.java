package com.ludo.tutorial.service;

import java.util.List;

import javax.validation.Valid;

import com.ludo.tutorial.model.Category;

public interface CategoryService {

	List<?> listCategories();

	long numCategories();

	void save(@Valid Category category);

	void deleteCategory(long id);

	Category getCategory(long id);

}
