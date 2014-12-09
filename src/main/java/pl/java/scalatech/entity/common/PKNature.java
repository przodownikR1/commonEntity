package pl.java.scalatech.entity.common;

import java.io.Serializable;

@FunctionalInterface
public interface PKNature<T> extends Serializable {
   T getId();
}