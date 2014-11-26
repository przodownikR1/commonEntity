package pl.java.scalatech.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

import lombok.Data;


@MappedSuperclass
@Data
public  abstract  class PKEntity<T extends Serializable>  {
  
    @Id
    @Min(0L)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, precision = 38, scale = 0)
    protected T id;

}
