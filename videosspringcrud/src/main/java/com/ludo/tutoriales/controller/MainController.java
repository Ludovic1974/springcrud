package com.ludo.tutoriales.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping({ "/", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();

		mv.addObject("titulo", "Hola Mundo");
		mv.addObject("descripcion",
				"En estos vídeos, aprenderás a crear un CRUD usando Spring MVC y el ORM de Hibernate sin ningún fichero XML.");
		String msj = "Versión 0.0.1 Hola Mundo!<br/>";
		msj += "Versión 0.0.2 Configuración de Bootstrap<br/>";
		msj += "Versión 0.0.3 Configuración del modelo Book<br/>";
		msj += "Versión 0.0.4 Configuración de un fichero de propiedades para externalizar las conexiones a BDD<br/>";
		msj += "Versión 0.0.5 Puesta en marcha de las capas de Service y DAO<br/>";
		msj += "Versión 0.0.6 Impresión en tabla de los libros incluidos en la base de datos<br/>";
		msj += "Versión 0.0.7 Configuración del formulario para ingresar nuevos libros<br/>";
		msj += "Versión 0.0.8 Añadir validación al formulario que sirve para ingresar nuevos libros<br/>";
		msj += "Versión 0.0.9 Añadir funciones para borrar registros de libros<br/>";
		msj += "Versión 0.1.0 Añadir funciones para editar registros de libros<br/>";
		msj += "Versión 0.1.1 Modificación del modelo Book: Lo extenderemos con el modelo DateColumns<br/>";
		msj += "Versión 0.1.2 Creación del modelo BookDetails y de la relación con Book. Configuración de la validación.<br/>";
		msj += "Versión 0.1.3 Creación del modelo Category y del formulario.<br/>";
		msj += "Versión 0.1.4 Modificación del formulario Book para asignar categorías a los libros.<br/>";
		msj += "Versión 0.1.5 Modificación de las interfaces del repositorio para respetar el principio de sustitución de Liskov.<br/>";
		msj += "Versión 0.1.6 Creación del model User.<br/>";
		msj += "Versión 0.1.7 Revisión global.<br/>";
		/*
		 * En la versión 0.1.7, se han llevado a cabo ciertas modificaciones al nivel de
		 * la NAV, de la variable menu de cada controlador. Además en el formulario
		 * User, he bloqueado la opción para modificar el username una vez creada.
		 */
		msj += "Versión 0.1.8 Extender la descripción de usuarios añadiendo la relación con el préstamo de Book.<br/>";
		msj += "Versión 0.1.9 Listar los libros prestados a un usuarios en modo Lazy.<br/>";
		msj += "Versión 0.2.0 Listar los libros prestados a UNOS usuarios en modo Lazy.<br/>";
		msj += "Versión 0.2.1 Validación de la contraseña. Los dos campos deben de ser iguales.<br/>";
		msj += "Versión 0.2.2 Validación de dos campos del formulario. Deben de ser iguales.<br/>";
		msj += "Versión 0.2.3 Validación del campo email. No debe de figurar en la BDD.<br/>";
		msj += "Versión 0.2.4 Creación del modelo Role.<br/>";
		msj += "Versión 0.2.5 Atribuir roles a los usuarios.<br/>";
		msj += "Versión 0.2.6 Añadir el inicio de sesión.<br/>";
		msj += "Versión 0.2.7 Finalizar la configuración del inicio de sesión.<br/>";
		msj += "Versión 0.2.8 Revisión global. Resolviendo un problema de seguridad.<br/>";
		msj += "Versión 0.2.9 Revisión global. Resolviendo un problema con el email del usuario actual.<br/>";
		msj += "Versión 0.3.0 Revisión global. Hacer que los roles de usuarios sean visibles.<br/>";
		mv.addObject("descripcion_larga", msj);
		mv.addObject("menu", "portada");
		mv.setViewName("index");

		return mv;
	}

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Página de login");
		mv.addObject("descripcion", "Presentación de las funciones login usando Spring Framework Security");
		mv.setViewName("login");

		return mv;
	}

	@GetMapping("/forbidden")
	public ModelAndView forbidden() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Contenidos restringidos");
		mv.addObject("descripcion", "Ups! Por lo que parece, no puedes acceder a estos contenidos.");
		mv.addObject("lorem", lorem());
		mv.setViewName("forbidden");

		return mv;
	}

	private String lorem() {
		String cadena = null;
		cadena += "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Morbi feugiat lacus ac enim eleifend, id sodales neque lobortis. "
				+ "Sed id dui nec elit aliquet condimentum non vel dolor. "
				+ "Quisque eget molestie dolor, vitae fermentum magna. "
				+ "Aenean sodales risus tristique, malesuada leo et, fringilla magna. Suspendisse malesuada semper orci ac aliquet. "
				+ "Proin faucibus nisl et augue elementum rutrum. "
				+ "Nunc et neque egestas, molestie ex eget, vehicula justo. Donec luctus porttitor nisi quis efficitur. "
				+ "Nulla pulvinar velit eu dolor posuere, a ultrices turpis molestie. "
				+ "Nunc varius rutrum ligula, quis auctor dolor ullamcorper ac. Nam in risus eu lorem scelerisque egestas.\r\n"
				+ "Nam ullamcorper commodo scelerisque. Proin risus lacus, "
				+ "consectetur rutrum vulputate non, pretium non odio. Sed dapibus eros magna, "
				+ "eu elementum eros mollis a. Curabitur non dui in sem suscipit dignissim. Donec commodo ex est, "
				+ "ut placerat quam tempus auctor. Maecenas dignissim, lacus a molestie sagittis, orci massa aliquet "
				+ "est, vitae porttitor eros est ac tellus. Nunc sed metus id elit dictum egestas. "
				+ "Suspendisse porttitor pulvinar pharetra. ";
		return cadena;

	}

}
