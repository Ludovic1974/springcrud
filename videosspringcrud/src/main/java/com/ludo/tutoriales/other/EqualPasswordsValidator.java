package com.ludo.tutoriales.other;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ludo.tutoriales.model.User;

public class EqualPasswordsValidator implements ConstraintValidator<EqualPasswords, User> {

	@Override
	public boolean isValid(User form, ConstraintValidatorContext context) {
		if (form.getPassword().equals(form.getConfirmPassword())) {
			System.out.println("contraseña valida");
		} else {
			System.out.println("contraseña invalida");
		}

		return form.getPassword().equals(form.getConfirmPassword());
	}

}
