package pl.java.scalatech.entity.common;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Getter;
import lombok.Setter;

import org.codehaus.jackson.annotate.JsonIgnore;




@MappedSuperclass
public class EntityCommonVersioning<T extends Serializable> extends EntityCommon<T> {
  
    @Version
    @JsonIgnore
    @XmlTransient
    @Getter
    @Setter
    protected long version;

}
