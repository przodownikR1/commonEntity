package pl.java.scalatech.test;

import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;

import lombok.Data;
import lombok.ToString;

import org.fest.assertions.Assertions;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.Ignore;
import org.junit.Test;


@Ignore
public class MoneyTest {
    
    @Test
    public void shouldMoneyEquals() {
        Money m1 = Money.of(CurrencyUnit.USD, new BigDecimal(12));
        Money m2 = Money.of(CurrencyUnit.USD, new BigDecimal(12));
        
        Assertions.assertThat(m1).isEqualTo(m2);
        Wrapper w1 = new Wrapper("slawek", m1);
        Wrapper w2 = new Wrapper("tomek", m2);
        assertThat(w1).isEqualTo(w2);
    }

    @Data
    @ToString
    class Wrapper {
        String name;
        Money salary;
        
        
        
        public Wrapper(String name, Money salary) {
            super();
            this.name = name;
            this.salary = salary;
        }
     
       
        
        
    }
}
