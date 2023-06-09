package de.tom.jakartaRestapi.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;

@Path("/api")
public class HttpCodesResource {

    @Path("/error")
    @GET
    public Response handleErrorRequest() {
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @Path("/ok")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleOkRequest() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", 200);
        jsonObject.put("content", "success");
        return Response.ok(jsonObject.toString()).build();
    }

}
