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
		String msj = "Versión 0.0.1 Hola mundo.<br/>";
		msj += "Versión 0.0.2 Configuración de estilos con Bootstrap.<br/>";
		msj += "Versión 0.0.3 Creación del modelo Book.<br/>";
		msj += "Versión 0.0.4 Creación de la carpeta resources.<br/>";
		msj += "Versión 0.0.5 Creación de las capas de negocio y de acceso a datos.<br/>";
		msj += "Versión 0.0.6 Impresión en tabla de los libros incluidos en la base de datos.<br/>";
		msj += "Versión 0.0.7 Configuración del formulario para incluir libros en la base de datos.<br/>";
		msj += "Versión 0.0.8 Validación del formulario.<br/>";
		msj += "Versión 0.0.9 Modificación del formulario para poder borrar libros.<br/>";
		msj += "Versión 0.1.0 Modificación del formulario para poder actualizar libros.<br/>";
		msj += "Versión 0.1.1 Modificación del modelo Book: Le extendemos al modelo DateColumns "
				+ "y añadimos dos columnas de fecha a la tabla. Indicarán cuando se ha creado un registro y cuando se ha actualizado.<br/>";
		msj += "Versión 0.1.2 Creación del modelo BookDetails y de la relación con Book. Configuración de la validación.<br/>";
		msj += "Versión 0.1.3 Creación del modelo Category y del formulario.<br/>";
		msj += "Versión 0.1.4 Modificación del formulario Book para asignar categorías a los libros.<br/>";
		msj += "Versión 0.1.5 Modificación de la estructura de interfaces.<br/>";
		msj += "Versión 0.1.6 Configuración completa del modelo User.<br/>";
		mv.addObject("descripcion",
				"En esta sección, aprenderemos cómo crear un CRUD usando Spring MVC e Hibernate ORM framework "
						+ "sin ningún fichero de configuración XML que no sea el POM de Maven.");
		mv.addObject("descripcion_larga", msj);
		mv.setViewName("index");

		return mv;
	}

}
