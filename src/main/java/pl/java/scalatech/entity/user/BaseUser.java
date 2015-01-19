package pl.java.scalatech.entity.user;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import pl.java.scalatech.entity.common.EntityCommonVersioning;
import pl.java.scalatech.entity.type.Sex;

@Entity
@Table(name = "users")
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class BaseUser extends EntityCommonVersioning {
    private static final long serialVersionUID = 3167444754591334354L;

    @NotEmpty
    @Length(min=2,max=30)
    @Column(name = "first_name", nullable = false, length = 30)
    protected String firstName;

    @NotEmpty
    @Length(min=2,max=256)
    @Column(name = "last_name", nullable = false, length = 256)
    protected String lastName;

    @Embedded
    private Address address;

    @NotEmpty
    @Email
    @JsonIgnore
    @XmlTransient
    @Transient
    private String mail;

    @Column(name = "birth_date")
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate birthDate;

    @NotNull
    @Size(max = 255)
    @Column(name = "mail", length = 255)
    private String enc_mail;

    @NotEmpty
    @Length(min=2,max = 30)
    @Transient
    @JsonIgnore
    @XmlTransient
    private String login;

    @Size(max = 255)
    @Column(name = "login", nullable = true, length = 255, unique = true)
    private String enc_login;

    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    @Column(name = "phone")
    private String phone;

}
