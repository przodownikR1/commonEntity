package pl.java.scalatech.test;

import java.time.LocalDate;

import lombok.extern.slf4j.Slf4j;

import org.junit.Before;
import org.junit.Test;

import pl.java.scalatech.entity.user.Address;
import pl.java.scalatech.entity.user.SecureUser;
@Slf4j
public class UserValidatorTest extends BaseEntityTest<SecureUser>{
    private Address address;
    private SecureUser secureUser;
    @Before
    public void init() {
        address = Address.builder().country("Poland").city("Warsaw").street("Krypska").streetNumber("17").zipcode("04-082").build();
        secureUser = SecureUser.builder().accountLock(false).attemptLoginCount(2).attemptLoginDate(LocalDate.now()).password("test").confirmPassword("test").build();

    }
    @Test
    public void shouldValidate(){
       log.info("{}", getConstraintViolations(secureUser));
    }

}
