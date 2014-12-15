package pl.java.scalatech.entity.common;



import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;



@Embeddable
@XmlRootElement(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location implements Serializable {  
    private static final long serialVersionUID = -2191631126853132555L;
    private  Double latitude;
    private  Double longitude;

}
