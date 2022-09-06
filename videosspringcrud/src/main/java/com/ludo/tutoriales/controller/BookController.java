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

import com.ludo.tutoriales.model.Book;
import com.ludo.tutoriales.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/list")
	public ModelAndView listBooks() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("book", new Book());
		mv.addObject("books", bookService.listBooks());
		mv.addObject("how_many", bookService.numBooks());
		mv.addObject("titulo", "Lista de libros");
		mv.addObject("titulo_form", "Formulario de libros");
		mv.addObject("descripcion", "En esta sección, después de haber creado instancias de libros, los listamos.");
		mv.addObject("descripcion_form", "Con este formulario, creamos nuevos libros.");

		mv.setViewName("listBook");

		return mv;
	}

	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") @Valid Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			addAttributes(model);

			return "listBook";
		}
		bookService.save(book);

		return "redirect:/book/list";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam("id") long id) {
		bookService.deleteBook(id);
		return "redirect:/book/list";
	}

	@GetMapping("/edit")
	public String editBook(@RequestParam("id") long id, Model model) {
		Book book = bookService.getBook(id);
		model.addAttribute(book);
		addAttributes(model);
		return "listBook";
	}

	private void addAttributes(Model model) {
		model.addAttribute("books", bookService.listBooks());
		model.addAttribute("how_many", bookService.numBooks());
		model.addAttribute("titulo", "Lista de libros");
		model.addAttribute("titulo_form", "Formulario de libros");
		model.addAttribute("descripcion",
				"En esta sección, después de haber creado instancias de libros, los listamos.");
		model.addAttribute("descripcion_form", "Con este formulario, creamos nuevos libros.");
	}

}
