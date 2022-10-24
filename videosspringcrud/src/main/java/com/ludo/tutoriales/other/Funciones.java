package com.ludo.tutoriales.other;

import java.lang.reflect.Field;

public class Funciones {

	public Funciones() {

	}

	public Object getFieldValue(Object object, String fieldname) throws Exception {
		Class<?> clazz = object.getClass();
		Field field = clazz.getDeclaredField(fieldname);
		field.setAccessible(true);
		return field.get(object);

	}

}
