package com.ludo.tutorial.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ludo.tutorial.model.Book;
import com.ludo.tutorial.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/list")
	public String listBooks(Model model) {
		model.addAttribute("book", new Book());
		String ttl = "Formulario libros";
		String msj = "En esta sección, después de haber creado instancias de libros, los listamos.";
		addAttributes(model, ttl, msj);

		return "listBook";
	}

	private void addAttributes(Model model, String ttl, String msj) {
		model.addAttribute("books", bookService.listBooks());
		model.addAttribute("how_many", bookService.numBooks());
		model.addAttribute("titulo", ttl);
		model.addAttribute("descripcion", msj);
	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult result, Model model) {

		if (result.hasErrors()) {
			model.addAttribute(book);
			addAttributes(model, "Formulario Libros", "Formulario para añadir/modificar los libros");

			return "listBook";
		}

		bookService.save(book);

		return "redirect:/book/list";
	}
}
