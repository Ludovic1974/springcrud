package com.ludo.tutoriales.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ludo.tutoriales.model.Category;
import com.ludo.tutoriales.service.CategoryService;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("category", new Category());
		mv.addObject("categories", categoryService.listCategories());
		mv.addObject("how_many", categoryService.numCategories());
		mv.addObject("titulo", "Lista de categorías");
		mv.addObject("titulo_form", "Formulario de categorías");
		mv.addObject("descripcion", "En esta sección, después de haber creado instancias de categorías, las listamos.");
		mv.addObject("descripcion_form", "Con este formulario, creamos nuevas categorías.");

		mv.setViewName("listCategory");

		return mv;
	}

	@PostMapping("/save")
	public String saveCategory(@ModelAttribute("category") @Valid Category category, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			addAttributes(model);

			return "listCategory";
		}
		categoryService.save(category);

		return "redirect:/category/list";
	}

	@GetMapping("/delete")
	public String deleteCategory(@RequestParam("id") long id) {
		categoryService.deleteCategory(id);
		return "redirect:/category/list";
	}

	@GetMapping("/edit")
	public String editCategory(@RequestParam("id") long id, Model model) {
		Category category = categoryService.getCategory(id);
		model.addAttribute(category);
		addAttributes(model);
		return "listCategory";
	}

	private void addAttributes(Model model) {
		model.addAttribute("categories", categoryService.listCategories());
		model.addAttribute("how_many", categoryService.numCategories());
		model.addAttribute("titulo", "Lista de categorías");
		model.addAttribute("titulo_form", "Formulario de categorías");
		model.addAttribute("descripcion",
				"En esta sección, después de haber creado instancias de categorías, los listamos.");
		model.addAttribute("descripcion_form", "Con este formulario, creamos nuevos categorías.");
	}

}
