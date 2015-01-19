package pl.java.scalatech.test;

import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import pl.java.scalatech.entity.user.UserRole;

@Slf4j
public class UserRoleValidatorTest extends BaseEntityTest<UserRole> {

    private UserRole userRole;

    @Before
    public void init() {
        userRole = UserRole.builder().role("ROLE_USER").desc("ordinary user role").build();
    }

    @Test
    public void shouldValidRole() {
        Assertions.assertThat(getConstraintViolations(userRole)).hasSize(0);
    }

    @Test
    public void shouldDescEmptyNotValid() {
        userRole.setDesc("");
        getConstraintViolations(userRole).stream().forEach(c -> log.info("+++  {}", c.getMessageTemplate()));
        Assertions.assertThat(getConstraintViolations(userRole)).hasSize(2);
        Assertions.assertThat(getConstraintViolations(userRole).stream().count()).isEqualTo(2);
        Assertions.assertThat(getConstraintViolations(userRole).iterator().next().getMessageTemplate()).isEqualTo("{org.hibernate.validator.constraints.NotEmpty.message}");
    }
    @Test
    public void shouldDescSizeNotValid() {
        userRole.setDesc("a");
        getConstraintViolations(userRole).stream().forEach(c -> log.info("+++  {}", c.getMessageTemplate()));
        Assertions.assertThat(getConstraintViolations(userRole)).hasSize(1);
        Assertions.assertThat(getConstraintViolations(userRole).iterator().next().getMessageTemplate()).isEqualTo("{javax.validation.constraints.Size.message}");
    }
    
    @Test
    public void shouldRolePatternNotValidOnlyLettersPermit() {
        userRole.setRole("PR2");
        getConstraintViolations(userRole).stream().forEach(c -> log.info("+++  {}", c.getMessageTemplate()));
        Assertions.assertThat(getConstraintViolations(userRole)).hasSize(1);
        Assertions.assertThat(getConstraintViolations(userRole).iterator().next().getMessageTemplate()).isEqualTo("{javax.validation.constraints.Pattern.message}");
    }
}
