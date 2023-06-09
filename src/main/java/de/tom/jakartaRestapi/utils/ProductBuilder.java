package de.tom.jakartaRestapi.utils;

import de.tom.jakartaRestapi.models.Product;

import java.util.ArrayList;

public class ProductBuilder {
    private String name;
    private double price;
    private ArrayList<String> categories;

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder addCategory(String category) {
        this.categories.add(category);
        return this;
    }

    public ProductBuilder removeCategory(String category) {
        this.categories.remove(category);
        return this;
    }

    public Product build() {
        return new Product(name, price, categories);
    }

}
