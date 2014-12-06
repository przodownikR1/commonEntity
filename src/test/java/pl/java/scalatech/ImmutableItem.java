package pl.java.scalatech;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;


@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public final class ImmutableItem {
    private final @NonNull @Getter String name;
    private final @NonNull @Getter Integer quantity;

}
