package pl.java.scalatech.test;

import java.util.Set;

import javax.validation.ConstraintViolation;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.extern.slf4j.Slf4j;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import pl.java.scalatech.entity.user.Address;

@Slf4j
public class AddressValidatorTest extends BaseEntityTest<Address> {

    private Address address;

    @Before
    public void init() {
        address = Address.builder().country("Poland").city("Warsaw").street("Krypska").streetNumber("17").zipcode("04-082").build();

    }

    @Test
    public void shouldAddressValidate() {
        Set<ConstraintViolation<Address>> constraintViolations = getConstraintViolations(address);
        Assertions.assertThat(constraintViolations).hasSize(0);
    }

    @Test
    public void shouldAddressCityNotEmptyValidate() {
        address = Address.builder().country("Poland").street("Krypska").streetNumber("17").zipcode("04-082").build();

        getConstraintViolations(address).stream().forEach(c -> log.info("+++  {}",c.getMessageTemplate()));
        
        
        Assertions.assertThat(getConstraintViolations(address)).hasSize(1);
    }

    @Test
    public void shouldAddressCountryNotEmptyValidate() {
        address = Address.builder().city("Warsaw").street("Krypska").streetNumber("17").zipcode("04-082").build();
        Set<ConstraintViolation<Address>> constraintViolations = getConstraintViolations(address);
        Assertions.assertThat(constraintViolations.iterator().next().getMessage()).isEqualTo("may not be empty");

        Assertions.assertThat(constraintViolations).hasSize(1);
    }

    @Test
   
    public void shouldAddressZipCodeValidate() {
        address = Address.builder().country("Poland").city("Warsaw").street("Krypska").streetNumber("17").zipcode("040-82").build();
        getConstraintViolations(address).stream().forEach(c -> log.info("+++  {}",c.getMessageTemplate()));
        Assertions.assertThat(getConstraintViolations(address)).hasSize(1);
        Assertions.assertThat(getConstraintViolations(address).iterator().next().getMessage()).contains("must match");
    }
}
