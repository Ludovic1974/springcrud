package com.ludo.tutoriales.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ludo.tutoriales.other.Funciones;

public class EqualFieldsValidator implements ConstraintValidator<EqualFields, Object> {

	private String baseField;
	private String matchField;
	private Funciones funciones;

	@Override
	public void initialize(EqualFields constraint) {
		this.baseField = constraint.baseField();
		this.matchField = constraint.matchField();
		this.funciones = new Funciones();
	}

	@Override
	public boolean isValid(Object object, ConstraintValidatorContext context) {
		try {
			Object baseFieldValue = funciones.getFieldValue(object, baseField);
			Object matchFieldValue = funciones.getFieldValue(object, matchField);
			return baseFieldValue != null && baseFieldValue.equals(matchFieldValue);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

}
