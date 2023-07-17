package br.com.gubee.interview.core.features.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RaceValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRace {
    String message() default "Valor de raça inválido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
