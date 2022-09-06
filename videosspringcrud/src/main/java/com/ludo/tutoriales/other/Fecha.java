package com.ludo.tutoriales.other;

import java.util.Calendar;
import java.util.Date;

public class Fecha {

	public static Date getTimeStamp() {

		Calendar cal = Calendar.getInstance();
		// mostrar la fecha y la hora
		Date date = cal.getTime();
		return date;

	}

}
