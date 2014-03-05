
package pl.java.scalatech.entity.user;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.java.scalatech.entity.common.EntityCommon;

/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  21 lut 2014 16:17:38
 
 */
@Entity
@Table(name = "roles")
@RequiredArgsConstructor(staticName = "of")
@NoArgsConstructor
@XmlRootElement(name = "userRole")
public class UserRole extends EntityCommon {

    private static final long serialVersionUID = 4217735871414498766L;

	@NotNull
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[A-Z_]+$")
    @Setter @Getter
	@NonNull
	private String role;

}
