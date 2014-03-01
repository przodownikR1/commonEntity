package pl.java.scalatech.entity.user;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.joda.time.DateTime;

import pl.java.scalatech.entity.annotation.PasswordsEqualConstraint;
import pl.java.scalatech.entity.common.Builder;
import pl.java.scalatech.entity.common.EntityCommonVersioning;
import pl.java.scalatech.entity.type.Sex;

/**
 * @author Sławomir Borowiec
 *         Module name : basicEntity
 *         Creating time : 21 lut 2014 16:17:33
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@PasswordsEqualConstraint(field = "confirmPassword")
@NoArgsConstructor
public abstract class BaseUser extends EntityCommonVersioning {
    private static final long serialVersionUID = 3167444754591334354L;

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
    private DateTime birthDate;

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
    private DateTime lastIncorrectLoginDate;

    @Column(name = "last_correct_login_date")
    private DateTime lastCorrectLoginDate;

    @Size(max = 20)
    @Column(name = "ip", length = 20)
    private String ip;

    @Enumerated(EnumType.ORDINAL)
    private Sex sex;

    @Column(name = "phone")
    private String phone;

    public BaseUser(UserBuilder<?> userBuilder) {
        this.firstName = userBuilder.firstName;
        this.lastName = userBuilder.lastName;
        this.address = userBuilder.address;
        this.login = userBuilder.login;
        this.password = userBuilder.password;
        this.mail = userBuilder.mail;
        this.ip = userBuilder.ip;
        this.sex = userBuilder.sex;
        this.phone = userBuilder.phone;

    }

    public static abstract class UserBuilder<T extends BaseUser> implements Builder<T> {
        private static final long serialVersionUID = -277742268898542431L;
        private final String firstName;
        private final String lastName;
        private final String password;
        private final String login;
        private DateTime birthDate;
        private Address address;
        private String mail;
        private String ip;
        private Sex sex;
        private String phone;

        public UserBuilder(String firstName, String lastName, String login, String password) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.login = login;
            this.password = password;
        }

        public UserBuilder<T> birthDate(@SuppressWarnings("hiding") DateTime birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder<T> phone(@SuppressWarnings("hiding") String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder<T> address(@SuppressWarnings("hiding") Address address) {
            this.address = address;
            return this;
        }

        public UserBuilder<T> mail(@SuppressWarnings("hiding") String mail) {
            this.mail = mail;
            return this;
        }

        public UserBuilder<T> sex(@SuppressWarnings("hiding") Sex sex) {
            this.sex = sex;
            return this;
        }

        public UserBuilder<T> ip(@SuppressWarnings("hiding") String ip) {
            this.ip = ip;
            return this;
        }


    }

}
