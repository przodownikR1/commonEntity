package pl.java.scalatech.entity.user;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pl.java.scalatech.entity.annotation.PasswordsEqualConstraint;

@Entity
@PasswordsEqualConstraint(field = "confirmPassword")
@Data
@EqualsAndHashCode(callSuper = true)
@DiscriminatorColumn(name = "User", discriminatorType = DiscriminatorType.STRING)
public class SecureUser extends BaseUser implements UserDetails {
    private static final long serialVersionUID = -6567709458397827407L;

    private String thumbnailUrl;

    private String email;
    private String activatedCode;
    private boolean activated;

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

 
    @Column(name = "attempt_login_count", nullable = false, precision = 4)
    private int attemptLoginCount = 0;

    @Column(name = "last_incorect_login_date")
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
    private LocalDate lastIncorrectLoginDate;

    @Column(name = "last_correct_login_date")
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
    private LocalDate lastCorrectLoginDate;

    @Size(max = 20)
    @Column(name = "ip", length = 20)
    private String ip;

    private LocalDate lastIncorrectLogin;

    private LocalDate attemptLoginDate;

    @OneToMany
    private List<UserRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> grantedAuthoritiesSet = new HashSet<>(getRoles().size());
        for (UserRole role : getRoles()) {
            grantedAuthoritiesSet.add(new SimpleGrantedAuthority(role.getRole().toUpperCase()));
        }
        return grantedAuthoritiesSet;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (!this.disabled && this.activated) { return true; }
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.disabled;
    }
}
