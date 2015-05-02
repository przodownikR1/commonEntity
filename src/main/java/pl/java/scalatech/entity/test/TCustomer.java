package pl.java.scalatech.entity.test;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import pl.java.scalatech.entity.audit.Audit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.Builder;
import lombok.extern.slf4j.Slf4j;


@Entity
@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper=true)
@Builder
@AllArgsConstructor
@Slf4j
public class TCustomer extends Audit{

 
    private static final long serialVersionUID = 1L;
    private @NonNull String name;
    private @NonNull String login;
    private  BigDecimal salary;
    public TCustomer(){
        log.info("constructor customer !!! ");
        
    }
    @OneToMany(cascade=CascadeType.ALL)
    private List<TPhone> phones;
    
   
}


