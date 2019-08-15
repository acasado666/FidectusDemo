package com.casado.rest.challenge.exception.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class MarketValidator implements ConstraintValidator<Market, String> {

    List<String> markets = Arrays.asList("Madrid", "Frankfurt", "Zurich");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return markets.contains(value);
    }
}
