package de.tom.jakartaRestapi.resources;

import de.tom.jakartaRestapi.models.Product;
import de.tom.jakartaRestapi.utils.ProductRepositoryInMemory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Collections;

@Path("/api")
public class ProductResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/product/{productName}")
    public String getData(@PathParam("productName") String productName) {
        return getProduct(productName).toString();
    }

    private static Product getProduct(String productName) {
        return ProductRepositoryInMemory
                .getInstance()
                .getAll()
                .stream()
                .filter(product -> product.getName().equals(productName))
                .findFirst()
                .orElse(new Product("", 0, Collections.EMPTY_LIST));
    }

    @PUT
    @Path(("/product/{productName}"))
    public Response deleteProduct(@PathParam("productName") String productName) {
        final Product product = getProduct(productName);
        ProductRepositoryInMemory
                .getInstance()
                .remove(product);
        return Response.ok("delete " + product).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path(("/product/{productName}"))
    public Response createProduct(@PathParam("productName") String productName) {
        final Product product = new Product(productName, 0.0, new ArrayList<>());
        ProductRepositoryInMemory
                .getInstance()
                .add(product);
        return Response.ok(product.toString()).build();

    }

}
