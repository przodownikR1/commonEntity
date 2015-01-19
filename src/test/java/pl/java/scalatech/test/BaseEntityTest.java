package pl.java.scalatech.test;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public abstract class BaseEntityTest<T> {
    private Validator validator;

    public BaseEntityTest() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    public Set<ConstraintViolation<T>> getConstraintViolations(T entity, Class<?>... groups) {
        return validator.validate(entity, groups);
    }
}