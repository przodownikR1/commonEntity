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
import lombok.experimental.Builder;
import pl.java.scalatech.entity.common.Location;


@Embeddable
@XmlRootElement(name = "address")
@Data
@Builder
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

   

 

}
