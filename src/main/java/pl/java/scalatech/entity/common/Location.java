package pl.java.scalatech.entity.common;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;


/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  21 lut 2014 13:40:16
 
 */
@Embeddable
@XmlRootElement(name = "address")
@Data
public class Location implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2191631126853132555L;
    private final Double latitude;
    private final Double longitude;

   

}
