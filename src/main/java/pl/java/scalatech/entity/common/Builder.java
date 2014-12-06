package pl.java.scalatech.entity.common;

import java.io.Serializable;


public interface Builder<T> extends Serializable{
    public abstract T build();
}
