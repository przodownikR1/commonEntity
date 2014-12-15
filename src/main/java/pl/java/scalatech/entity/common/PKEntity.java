package pl.java.scalatech.entity.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;


@MappedSuperclass
@Data
public abstract class PKEntity implements PKNature {
  
    private static final long serialVersionUID = 7669211182758111346L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    protected Long id;

}
