package pl.java.scalatech.entity.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

import lombok.Data;

/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  21 lut 2014 13:40:33
 
 */
@MappedSuperclass
@Data
public abstract class PKEntity implements Serializable {
  
    private static final long serialVersionUID = 7669211182758111346L;
    @Id
    @Min(0L)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, precision = 38, scale = 0)
    protected Long id;

}
