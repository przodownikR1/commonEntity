
package pl.java.scalatech.entity.common;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnore;


@MappedSuperclass
public abstract class EnityToken<T> extends PKEntity<T> {
    
    private static final long serialVersionUID = -7038220129873367795L;

    /** Web token. */
    @Transient
    @JsonIgnore 
    @XmlTransient
    @Setter @Getter
    protected String token;

 

}
