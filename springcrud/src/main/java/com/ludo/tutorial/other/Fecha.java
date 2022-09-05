package com.ludo.tutorial.other;

import java.util.Calendar;
import java.util.Date;

public class Fecha {

	public static Date getTimeStamp() {
		//El método getInstance() de la clase Calendar se utiliza 
		//para obtener un calendario utilizando la zona horaria 
		//y la configuración regional actuales del sistema.
		Calendar cal = Calendar.getInstance();
		//Mostrar la fecha y hora
		Date dateRepresentation = cal.getTime();
		return dateRepresentation;
	}
}
