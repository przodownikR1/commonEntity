package pl.java.scalatech.entity.common;

import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Type;


@MappedSuperclass
@Cacheable
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class EntityCommon extends EnityToken{

    private static final long serialVersionUID = -7901407735478652066L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modification")
    @Basic(fetch = FetchType.LAZY)
    @XmlTransient
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
    protected LocalDate dateModification;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    @Type(type = "org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
    @XmlTransient
    protected LocalDate dateAdded = LocalDate.now();

    @PreUpdate
    private void initPreUpdate() {
        dateModification = LocalDate.now();
        if (dateAdded == null) {
            dateAdded = dateModification;
        }
    }
    @Column(name = "disabled",nullable=false)
    protected boolean disabled = Boolean.FALSE.booleanValue();

}
