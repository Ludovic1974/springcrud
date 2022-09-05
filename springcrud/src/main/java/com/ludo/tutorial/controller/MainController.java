package com.ludo.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping({ "/", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Inserción de estilos tipo Bootstrap");
		String msj = "Versión 0.0.1 Hola mundo<br/>";
		msj += "Versión 0.0.2 Configuración de estilos con Bootstrap<br/>";
		msj += "Versión 0.0.3 Creación del modelo Book";
		mv.addObject("descripcion",
				"En esta sección, aprenderemos cómo crear un CRUD usando Spring MVC e Hibernate ORM framework "
						+ "sin ningún fichero de configuración XML que no sea el POM de Maven.");
		mv.addObject("descripcion_larga", msj);
		mv.setViewName("index");

		return mv;
	}

}
