package de.tom.jakartaRestapi.utils;

import de.tom.jakartaRestapi.interfaces.ProductRepository;
import de.tom.jakartaRestapi.models.Product;

import java.util.ArrayList;
import java.util.Collection;

public class ProductRepositoryInMemory implements ProductRepository {

    private static ProductRepositoryInMemory instance;
    private final Collection<Product> products;

    public ProductRepositoryInMemory() {
        this.products = new ArrayList<>();
    }

    public static ProductRepositoryInMemory getInstance() {
        if (instance == null) {
            instance = new ProductRepositoryInMemory();
        }
        return instance;
    }

    @Override
    public Collection<Product> getAll() {
        return this.products;
    }

    @Override
    public void add(Product product) {
        this.products.add(product);
    }

    @Override
    public void remove(Product product) {
        this.products.remove(product);
    }
}
