package pl.java.scalatech.test;

import static org.fest.assertions.Assertions.assertThat;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import pl.java.scalatech.ConcreteUser;
import pl.java.scalatech.entity.common.Location;
import pl.java.scalatech.entity.type.Sex;
import pl.java.scalatech.entity.user.Address;

/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  27 lut 2014 15:34:04
 
 */
@Ignore
public class UserBuilderTest {
    private static final String CITY = "WARSZAWA";
    private static final String COUNTRY = "POLAND";
    private static final String HOME_NUMBER = "8";
    private static final String STREET_NUMBER = "20";
    private static final String ZIP = "04-128";
    private static final String STREET = "Krypska";
    private static final Location LOCATION = new Location(12d, 23d);
    private static final String FIRST_NAME = "slawek";
    private static final String LAST_NAME = "borowiec";
    private static final String LOGIN = "przodownik_pracy";
    private static final String MAIL = "przodownikR1@gmail.com";
    private static final String PASSWORD = "secret";
    private static final String IP = "127.0.0.1";
    private static final Sex MALE = Sex.Male;
    private static final String PHONE = "111222333";
    private static final DateTime BIRTH_DATE = new DateTime();
    private static final Money SALARY = Money.of(CurrencyUnit.USD, 100);
    private Address address;
    private ConcreteUser concreteUser;

    @Before
    public void init() {
        address = new Address();
        address.setCity(CITY);
        address.setCountry(COUNTRY);
        address.setHomeNumber(HOME_NUMBER);
        address.setLocation(LOCATION);
        address.setStreet(STREET);
        address.setStreetNumber(STREET_NUMBER);
        address.setZipcode(ZIP);
        concreteUser = new  ConcreteUser();
        concreteUser.setAddress(address);
        
        concreteUser.setBirthDate(BIRTH_DATE);
        concreteUser.setLogin(LOGIN);
        concreteUser.setPassword(PASSWORD);
        concreteUser.setMail(MAIL);
        concreteUser.setFirstName(FIRST_NAME);
        concreteUser.setLastName(LAST_NAME);
        concreteUser.setIp(IP);
        concreteUser.setSex(MALE);
        concreteUser.setPhone(PHONE);
        concreteUser.setSalary(SALARY);
        
    }

    @Test
    public void shouldBuildUserProperly() {
        // given user
        // when
       ConcreteUser concreteUserToCompare= new ConcreteUser.ConcreteUserBuilder(FIRST_NAME,LAST_NAME,LOGIN,PASSWORD).salary(SALARY).
               address(address).birthDate(BIRTH_DATE).ip(IP).mail(MAIL).phone(PHONE).sex(MALE).
               build();
        // then
        assertThat(concreteUserToCompare).isEqualTo(concreteUser);
 
    }

    @Test
    public void shouldBuildUserImproperlyWithoutMail() {
        // given user
        // when
        ConcreteUser concreteUserToCompare= new ConcreteUser.ConcreteUserBuilder(FIRST_NAME,LAST_NAME,LOGIN,PASSWORD).salary(SALARY).
                address(address).birthDate(BIRTH_DATE).ip(IP).phone(PHONE).sex(MALE).
                build();
        // then
        assertThat(concreteUserToCompare).isNotEqualTo(concreteUser);
    }

}
