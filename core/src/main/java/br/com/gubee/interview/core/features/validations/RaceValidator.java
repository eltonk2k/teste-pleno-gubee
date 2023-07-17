package br.com.gubee.interview.core.features.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RaceValidator implements ConstraintValidator<ValidRace, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && (value.equals("HUMAN") || value.equals("ALIEN") || value.equals("DIVINE") || value.equals("CYBORG"));
    }
}

