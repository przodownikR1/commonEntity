package pl.java.scalatech.entity.common;

import java.io.Serializable;
import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
@Cacheable
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class EntityCommon<T extends Serializable> extends PKEntity<T> {

    @Column(name = "date_modification")
    @Basic(fetch = FetchType.LAZY)
    @DateTimeFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    protected Date dateModification;

    @Setter
    @Getter
    protected Boolean disabled = Boolean.FALSE;

    @Column(name = "DATE_ADDED", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    @DateTimeFormat(pattern = "MM-dd-yyyy HH:mm:ss")
    protected Date dateAdded = new Date();

    @PreUpdate
    private void initPreUpdate() {
        dateModification = new Date();
        if (dateAdded == null) {
            dateAdded = dateModification;
        }
    }

}
