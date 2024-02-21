package project.domain.account.validation;

import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({FIELD, METHOD, PARAMETER, TYPE})
public @interface UniqueAccount {
    String message() default "Duplicated Account";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
