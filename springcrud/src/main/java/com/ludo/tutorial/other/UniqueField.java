package com.ludo.tutorial.other;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueFieldValidator.class)
public @interface UniqueField {
	String message() default "{user.email.exist}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
