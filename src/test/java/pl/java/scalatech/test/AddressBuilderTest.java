package pl.java.scalatech.test;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import pl.java.scalatech.entity.common.Location;
import pl.java.scalatech.entity.user.Address;

/**
 * @author Sławomir Borowiec
 *         Module name : basicEntity
 *         Creating time : 24 lut 2014 11:43:55
 */
public class AddressBuilderTest {

    private static final String CITY = "WARSZAWA";
    private static final String COUNTRY = "POLAND";
    private static final String HOME_NUMBER = "8";
    private static final String STREET_NUMBER = "20";
    private static final String ZIP = "04-128";
    private static final String STREET = "Krypska";
    private static final Location LOCATION = new Location(12d, 23d);
    private Address address;

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
    }

    @Test
    public void shouldBuildAddressProperly() {
        // given Address
        // when
        Address addressToCompare = new Address.AddressBuilder(COUNTRY, CITY).homeNumber(HOME_NUMBER).location(LOCATION).street(STREET)
                .streetNumber(STREET_NUMBER).zipCode(ZIP).build();
        // then
        assertThat(addressToCompare).isEqualTo(address);

    }

    @Test
    public void shouldBuildAddressImproperlyWithoutZipCode() {
        // given Address
        // when
        Address addressToCompare = new Address.AddressBuilder(COUNTRY, CITY).homeNumber(HOME_NUMBER).location(LOCATION).street(STREET)
                .streetNumber(STREET_NUMBER).build();
        // then
        assertThat(addressToCompare).isNotEqualTo(address);
    }

}
