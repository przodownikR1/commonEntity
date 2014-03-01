
package pl.java.scalatech.entity.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.java.scalatech.entity.annotation.PasswordsEqualConstraint;
import pl.java.scalatech.entity.user.BaseUser;

/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  21 lut 2014 16:19:13
 
 */
public class PasswordsEqualConstraintValidator implements ConstraintValidator<PasswordsEqualConstraint, BaseUser> {

    @Override
    public void initialize(PasswordsEqualConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(BaseUser user, ConstraintValidatorContext context) {
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            return false;
        }
        return true;
    }

}
