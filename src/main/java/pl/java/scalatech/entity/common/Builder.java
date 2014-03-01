package pl.java.scalatech.entity.common;

import java.io.Serializable;

/**
 * @author Sławomir Borowiec 
 * Module name : basicEntity
 * Creating time :  27 lut 2014 14:04:23
 
 * @param <T>
 */
public interface Builder<T> extends Serializable{
    public abstract T build();
}
