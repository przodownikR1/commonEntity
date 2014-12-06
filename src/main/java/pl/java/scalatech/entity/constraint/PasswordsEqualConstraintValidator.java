package pl.java.scalatech.entity.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.java.scalatech.entity.annotation.PasswordsEqualConstraint;
import pl.java.scalatech.entity.user.SecureUser;

public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, SecureUser> {

    @Override
    public void initialize(PasswordsEqualConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(SecureUser user, ConstraintValidatorContext context) {
        if (!user.getPassword().equals(user.getConfirmPassword())) { return false; }
        return true;
    }

}
