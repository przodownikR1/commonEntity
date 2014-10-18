package pl.java.scalatech;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.joda.money.Money;

import pl.java.scalatech.entity.user.BaseUser;

/**
 * @author Sławomir Borowiec
 *         Module name : basicEntity
 *         Creating time : 27 lut 2014 15:19:35
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class ConcreteUser extends BaseUser {

    public ConcreteUser(ConcreteUserBuilder concreteUserBuilder) {
        super(concreteUserBuilder);
        this.salary = concreteUserBuilder.salary;
    }

    /**
         * 
         */
    private static final long serialVersionUID = 1L;

    private Money salary ;

    public static class ConcreteUserBuilder extends UserBuilder<ConcreteUser> {

        public ConcreteUserBuilder(String firstName, String lastName, String login, String password) {
            super(firstName, lastName, login, password);
        }

        private static final long serialVersionUID = 3095189519520925314L;
        private Money salary;

        public ConcreteUserBuilder salary(Money salary) {
            this.salary = salary;
            return this;
        }

        @Override
        public ConcreteUser build() {
            return new ConcreteUser(this);
        }

    }

}
