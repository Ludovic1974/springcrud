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
import org.springframework.web.bind.annotation.RequestParam;

import com.ludo.tutorial.model.User;
import com.ludo.tutorial.service.BookService;
import com.ludo.tutorial.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@GetMapping("/list")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		addAttributes(model);
		return "listUser";
	}

	@GetMapping("/edit")
	public String editUser(@RequestParam("username") String username, Model model) {
		User user = userService.getUser(username);
		model.addAttribute(user);
		addAttributes(model);
		return "listUser";
	}

	private void addAttributes(Model model) {
		model.addAttribute("users", userService.ListWithBooks());
		model.addAttribute("how_many", userService.numUsers());
		model.addAttribute("titulo", "Formulario Usuarios");
		model.addAttribute("descripcion", "Formulario para añadir/modificar los usuarios");
		model.addAttribute("menu", "lista_usuarios");
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(user);
			addAttributes(model);
			return "listUser";
		}
		userService.save(user);
		return "redirect:/user/list";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("username") String username) {
		userService.deleteUser(username);
		return "redirect:/user/list";
	}

	@GetMapping("/loan_books")
	public String loanBooksUser(@RequestParam("username") String username, Model model) {
		User user = userService.getUserWithBooks(username);
		model.addAttribute(user);
		model.addAttribute("booklist", bookService.listBooks());
		model.addAttribute("titulo", "Listado de libros prestados a " + user.getName());
		model.addAttribute("descripcion", "Formulario para añadir/modificar libros prestados por " + user.getName());

		return "loanBooks";
	}

	@PostMapping("/confirm_loan")
	public String confirmLoan(@ModelAttribute("user") @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute(user);
			addAttributes(model);
			return "listUser";
		}
		userService.loanBooks(user);
		model.addAttribute(user);
		addAttributes(model);
		return "redirect:/user/list";
	}

}
