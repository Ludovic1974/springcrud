package com.ludo.tutoriales.other;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.ludo.tutoriales.service.UserService;

public class UniqueFieldValidator implements ConstraintValidator<UniqueField, String> {

	@Autowired
	private UserService userService;;

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		List<?> userListFound = userService.findByEmail(email);
		if (!userListFound.isEmpty()) {
			return false;
		}

		return true;
	}

}
