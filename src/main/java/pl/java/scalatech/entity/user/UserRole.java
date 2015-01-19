package pl.java.scalatech.entity.user;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Builder;
import pl.java.scalatech.entity.common.EntityCommon;
import pl.java.scalatech.entity.user.SecureUser.SecureUserBuilder;

@Entity
@Table(name = "roles")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "userRole")
@Builder
public class UserRole extends EntityCommon {

    private static final long serialVersionUID = 4217735871414498766L;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[A-Z_]+$")
    @NonNull
    private String role;
    @NotEmpty
    @Size(min = 2, max = 50)
    @Column(name = "desc_role")
    private String desc;
    
 
}
