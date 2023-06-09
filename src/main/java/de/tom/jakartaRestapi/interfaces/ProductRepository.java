package de.tom.jakartaRestapi.interfaces;

import de.tom.jakartaRestapi.models.Product;

import java.util.Collection;

public interface ProductRepository {
    Collection<Product> getAll();
    void add(Product product);
    void remove(Product product);
}
