package pl.java.scalatech.entity.audit;

import java.util.Date;

import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import pl.java.scalatech.entity.common.PKEntity;
import pl.java.scalatech.entity.user.BaseUser;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
@ToString(exclude={"createdDate","lastModifiedDate","createdBy","lastModifiedBy"})
@EqualsAndHashCode(callSuper=true)
public abstract class Audit extends PKEntity{
    private static final long serialVersionUID = 2663518387056045900L;

    @CreatedDate
    private Date createdDate = new Date();

    @LastModifiedDate
    private Date lastModifiedDate = new Date();

    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private BaseUser createdBy;

    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private BaseUser lastModifiedBy;

}