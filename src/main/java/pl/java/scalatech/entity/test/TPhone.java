package pl.java.scalatech.entity.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TPhone {
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String number;
    public TPhone(String number) {
        super();
        this.number = number;
    }
    
}
