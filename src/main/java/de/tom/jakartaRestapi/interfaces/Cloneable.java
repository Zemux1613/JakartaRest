package de.tom.jakartaRestapi.interfaces;

public interface Cloneable<T> {
    T clone();

    T deeplClone();
}
