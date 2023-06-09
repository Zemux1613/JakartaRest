package de.tom.jakartaRestapi.resources;

import de.tom.jakartaRestapi.models.Product;
import de.tom.jakartaRestapi.utils.ProductRepositoryInMemory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Optional;

@Path("/api")
public class ProductResource {

    @GET
    @Path("/product/{productName}")
    public Product getData(@PathParam("productName") String productName) {
        return ProductRepositoryInMemory
                .getInstance()
                .getAll()
                .stream()
                .filter(product -> product.getName().equals(productName))
                .findFirst()
                .orElse(null);
    }

    @PUT
    @Path(("/product/{productName}"))
    public void deleteProduct(@PathParam("productName") String productName) {
        ProductRepositoryInMemory
                .getInstance()
                .remove(
                        getData(productName)
                );
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
