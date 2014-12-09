package pl.java.scalatech.entity.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.java.scalatech.entity.common.EntityCommon;

@Entity
@Table(name = "roles")
@Data
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@XmlRootElement(name = "userRole")
public class UserRole extends EntityCommon<Long> {

    private static final long serialVersionUID = 4217735871414498766L;

    @NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[A-Z_]+$")
    @NonNull
    private String role;

    @Size(min = 2, max = 50)
    @Column(name = "desc_role")
    private String desc;

}
