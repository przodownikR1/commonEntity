package pl.java.scalatech.entity.common;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

import lombok.Data;


@MappedSuperclass
@Data
public abstract class PKEntity<T> implements PKNature<T> {
  
    private static final long serialVersionUID = 7669211182758111346L;
    @Id
    @Min(0L)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, precision = 38, scale = 0)
    protected T id;

}
