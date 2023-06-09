package de.tom.jakartaRestapi.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.json.JSONObject;

@Path("/api")
public class HelloResource {

    @Path("/hello")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHelloName(@QueryParam("name") String name) {
        JSONObject jsonObject = new JSONObject();
        if(name == null){
            jsonObject.put("content", "hello world");
            return jsonObject.toString();
        }

        jsonObject.put("content", name);
        return jsonObject.toString();
    }
}
