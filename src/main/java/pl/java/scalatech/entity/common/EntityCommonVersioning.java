package pl.java.scalatech.entity.common;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  21 lut 2014 13:43:10
 
 */
@MappedSuperclass
public class EntityCommonVersioning extends EntityCommon {
    private static final long serialVersionUID = -4054868885539004220L;

    @Version
    @JsonIgnore
    @XmlTransient
    @Getter
    @Setter
    protected long version;

}
