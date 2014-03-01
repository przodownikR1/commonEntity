package pl.java.scalatech.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.scalatech.entity.common.Builder;
import pl.java.scalatech.entity.common.Location;

/**
 * @author Sławomir Borowiec
 *         Module name : basicEntity
 *         Creating time : 21 lut 2014 13:46:00
 */
@Embeddable
@XmlRootElement(name = "address")
@Data
@NoArgsConstructor
public class Address implements Serializable {
    private static final long serialVersionUID = -5271571702826932282L;
    @NotNull
    @Size(min = 2, max = 30)
    @Pattern(regexp = ".+")
    @Column(name = "country", nullable = false, length = 30)
    private String country;

    @NotNull
    @Size(min = 2, max = 50)
    @Pattern(regexp = ".+")
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    @Column(name = "street", length = 50)
    private String street;

    @Column(name = "street_number", length = 4)
    private String streetNumber;

    @Column(name = "home_number", length = 3)
    private String homeNumber;

    @Embedded
    private Location location;

    @Column(nullable = false, length = 6)
    @Pattern(regexp = "^\\d{2}-\\d{3}$")
    private String zipcode;

    public Address(AddressBuilder addressBuilder) {
        this.city = addressBuilder.city;
        this.country = addressBuilder.country;
        this.homeNumber = addressBuilder.homeNumber;
        this.location = addressBuilder.location;
        this.street = addressBuilder.street;
        this.streetNumber = addressBuilder.streetNumber;
        this.zipcode = addressBuilder.zipCode;
    }

    public static class AddressBuilder implements Builder<Address> {

        private static final long serialVersionUID = 6868681866154038647L;
        private final String country;
        private final String city;
        private String street;
        private String streetNumber;
        private String homeNumber;
        private Location location;
        private String zipCode;

        public AddressBuilder(String country, String city) {
            this.country = country;
            this.city = city;
        }

        public AddressBuilder street(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder streetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressBuilder homeNumber(String homeNumber) {
            this.homeNumber = homeNumber;
            return this;
        }

        public AddressBuilder location(Location location) {
            this.location = location;
            return this;
        }

        public AddressBuilder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        @Override
        public Address build() {
            return new Address(this);
        }
    }

}
