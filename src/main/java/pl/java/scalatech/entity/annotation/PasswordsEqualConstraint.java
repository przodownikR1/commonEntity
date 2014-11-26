
package pl.java.scalatech.entity.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import pl.java.scalatech.entity.constraint.PasswordsEqualConstraintValidator;



@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Size(min = 6)
@NotEmpty
@Constraint(validatedBy = PasswordsEqualConstraintValidator.class)
public @interface PasswordsEqualConstraint {
    String message() default "Wrong password";

    String field();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
