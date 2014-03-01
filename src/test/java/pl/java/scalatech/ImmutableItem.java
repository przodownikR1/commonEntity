package pl.java.scalatech;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  27 lut 2014 17:57:05
 
 */
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public final class ImmutableItem {
    private final @NonNull @Getter String name;
    private final @NonNull @Getter int quantity;

}
