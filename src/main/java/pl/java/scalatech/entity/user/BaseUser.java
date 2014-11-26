package pl.java.scalatech.entity.user;

import java.io.Serializable;
import java.util.Date;

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
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import pl.java.scalatech.entity.annotation.PasswordsEqualConstraint;
import pl.java.scalatech.entity.common.EntityCommonVersioning;
import pl.java.scalatech.entity.type.Sex;


@Entity
@Table(name = "base_users")
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@PasswordsEqualConstraint(field = "confirmPassword")
public abstract class BaseUser<T extends Serializable> extends EntityCommonVersioning<T> {
   

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "first_name", nullable = false, length = 30)
    protected String firstName;

    @NotNull
    @Size(min = 2, max = 50)
    @Column(name = "last_name", nullable = false, length = 256)
    protected String lastName;

    @Embedded
    private Address address;

    @NotNull
    @Size(max = 50)
    @Email
    @JsonIgnore
    @XmlTransient
    @Transient
    private String mail;

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date birthDate;

    @NotNull
    @Size(max = 255)
    @Column(name = "mail", length = 255)
    private String enc_mail;

    @NotNull
    @Size(max = 30)
    @Transient
    @JsonIgnore
    @XmlTransient
    private String login;

    @Size(max = 255)
    @Column(name = "login", nullable = true, length = 255, unique = true)
    private String enc_login;

    @Column(name = "logged", nullable = false)
    private boolean logged;

    @Column(name = "account_lock", nullable = false)
    private boolean accountLock;

    @Transient
    @XmlTransient
    @JsonIgnore
    private String confirmPassword;

    @Transient
    @XmlTransient
    @JsonIgnore
    private String password;

    @Column(name = "password", length = 255)
    private String enc_password;

    @NotNull
    @Column(name = "attempt_login_count", nullable = false, precision = 4)
    private int attemptLoginCount = 0;

    @Column(name = "last_incorect_login_date")
    private Date lastIncorrectLoginDate;

    @Column(name = "last_correct_login_date")
    private Date lastCorrectLoginDate;

    @Size(max = 20)
    @Column(name = "ip", length = 20)
    private String ip;

    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    @Column(name = "phone")
    private String phone;

  

}
