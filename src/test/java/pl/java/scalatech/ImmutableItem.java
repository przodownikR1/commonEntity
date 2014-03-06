package pl.java.scalatech;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  27 lut 2014 17:57:05
 
 */
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public final class ImmutableItem {
    private final @NonNull @Getter String name;
    private final @NonNull @Getter Integer quantity;

}
