package pl.java.scalatech.entity.user;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.java.scalatech.entity.common.EntityCommon;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Activation extends EntityCommon {
    private static final long serialVersionUID = -404234418472978546L;

    private String activatedCode;

    private boolean activated;
}
