package de.tom.jakartaRestapi.models;

import de.tom.jakartaRestapi.interfaces.Cloneable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
@Getter
public class Product implements Cloneable<Product> {
    private String name;
    private double price;
    private Collection<String> categories;

    @Override
    public Product clone() {
        return new Product(name, price, categories);
    }

    @Override
    public Product deeplClone() {
        return new Product(name, price, new ArrayList<>(categories));
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + String.join(",", categories) +
                '}';
    }
}
