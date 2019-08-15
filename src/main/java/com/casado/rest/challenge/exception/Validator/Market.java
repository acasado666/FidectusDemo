package com.casado.rest.challenge.exception.Validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = MarketValidator.class)
@Documented
public @interface Market {

    String message() default "Market not allowed or Unknown.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
