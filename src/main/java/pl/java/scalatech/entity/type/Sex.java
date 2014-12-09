package pl.java.scalatech.entity.type;

import lombok.Getter;

public enum Sex {
    MALE("male.message"), FEMALE("female.message");

    private Sex(String name) {
        this.name = name;
    }

    @Getter
    private String name;

}
