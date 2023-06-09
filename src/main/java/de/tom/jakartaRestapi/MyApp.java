package de.tom.jakartaRestapi;

import com.sun.net.httpserver.HttpServer;
import de.tom.jakartaRestapi.resources.HelloResource;
import de.tom.jakartaRestapi.resources.HttpCodesResource;
import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class MyApp {
    public static void main(String[] args) {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
        ResourceConfig config = new ResourceConfig();
        //config.register(HelloResource.class);
        config.register(HttpCodesResource.class);
        final HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);

        System.out.println("Server started at " + baseUri);
        System.out.println("Press Ctrl + C to stop the server");

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            server.stop(0);
        }
    }
}