package com.ludo.tutoriales.other;

import java.lang.reflect.Field;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EqualFieldsValidator implements ConstraintValidator<EqualFields, Object> {

	private String baseField;
	private String matchField;

	@Override
	public void initialize(EqualFields constraint) {
		baseField = constraint.baseField();
		matchField = constraint.matchField();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		try {
			Object baseFieldValue = getFieldValue(object, baseField);
			Object matchFieldValue = getFieldValue(object, matchField);
			return baseFieldValue != null && baseFieldValue.equals(matchFieldValue);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	private Object getFieldValue(Object object, String fieldname) throws Exception {
		Class<?> clazz = object.getClass();
		Field field = clazz.getDeclaredField(fieldname);
		field.setAccessible(true);
		return field.get(object);

	}

}
