package com.ludo.tutoriales.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

import com.ludo.tutoriales.dto.UserDto;
import com.ludo.tutoriales.model.Book;
import com.ludo.tutoriales.model.Role;
import com.ludo.tutoriales.model.User;
import com.ludo.tutoriales.service.BookService;
import com.ludo.tutoriales.service.RoleService;
import com.ludo.tutoriales.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@Autowired
	private RoleService roleService;

	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("user", new User());
		addAttributes(model);
		return "listUser";
	}

	private void addAttributes(Model model) {
		model.addAttribute("users", userService.listWithBooks());
		model.addAttribute("how_many", userService.numUsers());
		model.addAttribute("titulo", "Formulario usuarios");
		model.addAttribute("descripcion",
				"En esta sección, después de haber creado instancias de usuarios, las listamos.");
		model.addAttribute("menu", "lista_usuarios");
	}

	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result, Model model) {
		String equalPasswords = null;
		String emailExist = null;
		if (result.hasErrors()) {
			System.out.println("Número de errores: " + result.getErrorCount());
			System.out.println("EqualPasswords.user: " + result.getFieldErrors());
			System.out.println("Todos errores: " + result.getAllErrors().get(0).getDefaultMessage());

			for (int i = 0; i < result.getAllErrors().size(); i++) {
				if (result.getAllErrors().get(i).getDefaultMessage().equals("Las contraseñas no son iguales")) {
					equalPasswords = "Las contraseñas no son iguales";
					continue;
				}
				if (result.getAllErrors().get(i).getDefaultMessage().equals("Este email ya está registrado")) {
					emailExist = "Este email ya está registrado";

				}
			}
			model.addAttribute("equalPasswords", equalPasswords);
			model.addAttribute("emailExist", emailExist);
			model.addAttribute(userDto);
			addAttributes(model);
			return "listUser";
		}
		User user = new User(userDto);
		userService.save(user);
		return "redirect:/user/list";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("username") String username) {
		userService.deleteUser(username);
		return "redirect:/user/list";
	}

	@GetMapping("/edit")
	public String editUser(@RequestParam("username") String username, Model model) {
		User user = userService.getUser(username);
		model.addAttribute(user);
		addAttributes(model);
		return "listUser";
	}

	@GetMapping("/loan_books")
	public String loanBooksUser(@RequestParam("username") String username, Model model) {
		User user = userService.getUserWithBooks(username);
		model.addAttribute("booklist", bookService.listBooks());
		model.addAttribute(user);
		model.addAttribute("titulo", "Listado de libros prestados a " + user.getName());
		model.addAttribute("descripcion", "Formulario para añadir / modificar libros prestados a " + user.getName());

		return "loanBooks";
	}

	@PostMapping("/confirm_loan")
	public String confirmLoan(@ModelAttribute("user") User userSent, Model model) {
		User user = userService.getUserWithBooks(userSent.getUsername());
		List<Book> books = userSent.getBooks();
		user.setBooks(books);
		userService.loanBooks(user);
		return "redirect:/user/list";
	}

	@GetMapping("/role")
	public String userRole(@RequestParam("username") String username, Model model) {
		User user = userService.getUser(username);
		model.addAttribute("role", new Role());
		addAttributes(model, user);
		return "userRole";
	}

	@PostMapping("/add_role")
	public String addRole(@ModelAttribute("role") @Valid Role role, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("Roles - cuantos errores ha habido? : " + result.getErrorCount());
			System.out.println("Roles - listando los errores: " + result.getAllErrors());
			User user = userService.getUser(role.getUser().getUsername());
			addAttributes(model, user);
			return "userRole";
		}

		roleService.save(role);

		return "redirect:/user/list";
	}

	private void addAttributes(Model model, User user) {
		model.addAttribute(user);
		ArrayList<String> rolelist = new ArrayList<String>(Arrays.asList("ROLE_USER", "ROLE_WRITER", "ROLE_ADMIN"));
		model.addAttribute("rolelist", rolelist);

		model.addAttribute("titulo", "Gestionar permisos de " + user.getName());
		model.addAttribute("descripcion", "Tabla que muestra los detalles acerca de " + user.getName());
	}

}
