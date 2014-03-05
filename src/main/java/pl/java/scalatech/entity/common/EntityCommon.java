package pl.java.scalatech.entity.common;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  21 lut 2014 13:43:20
 
 */
@MappedSuperclass
@Cacheable
@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
public abstract class EntityCommon extends EnityToken {

    private static final long serialVersionUID = -7901407735478652066L;

    @Column(name = "date_modification")
    @Basic(fetch = FetchType.LAZY)
	@DateTimeFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    protected DateTime dateModification;

    
    @Setter
    @Getter
    protected Boolean disabled = Boolean.FALSE;
    
    @Column(name = "DATE_ADDED", nullable = false)
    @Basic(fetch = FetchType.LAZY)
	@DateTimeFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    protected DateTime dateAdded = new DateTime();

    @PreUpdate
    private void initPreUpdate() {
        dateModification = new DateTime();
        if (dateAdded == null) {
            dateAdded = dateModification;
        }
    }

}
