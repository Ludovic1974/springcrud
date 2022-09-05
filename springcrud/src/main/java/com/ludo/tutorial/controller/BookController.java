package com.ludo.tutorial.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ludo.tutorial.model.Book;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	@GetMapping("/list")
	public ModelAndView listBooks() {
		ModelAndView mv = new ModelAndView();
		Book book1 = new Book(1, "Ejemplo de libro 1", "Lui Même");
		Book book2 = new Book(2, "Ejemplo de libro 2", "Otro autor");
		ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(book1, book2));
		mv.addObject("books", books);
		mv.addObject("titulo", "Lista de libros");

		mv.addObject("descripcion", "En esta sección, después de haber creado instancias de libros, los listamos.");

		mv.setViewName("listBook");

		return mv;
	}
}
