package com.ludo.tutorial.other;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/*
 * La solución presentada anteriormente tiene una desventaja muy obvia: la
 * anotación de restricción se puede aplicar solo a una clase, por lo tanto, es
 * completamente inutilizable. Sería mejor si pudiéramos usarlo en cualquier
 * clase y permitir parametrizar qué campos deberían compararse.
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
/* Pondremos un nombre más genérico a la clase validator */
@Constraint(validatedBy = { EqualFieldsValidator.class })
/* Cambiando el nombre de la clase */
public @interface EqualFields {

	String message() default "{user.fields.not.igual}";
	/* Actualización del mensaje */

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String baseField();

	String matchField();

}
