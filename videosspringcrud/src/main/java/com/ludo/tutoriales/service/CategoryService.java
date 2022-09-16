package com.ludo.tutoriales.service;

import java.util.List;

import javax.validation.Valid;

import com.ludo.tutoriales.model.Category;

public interface CategoryService {

	List<?> listCategories();

	Long numCategories();

	void save(@Valid Category category);

	void deleteCategory(long id);

	Category getCategory(long id);

}
