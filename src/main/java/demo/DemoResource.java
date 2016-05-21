package demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anthony on 5/20/16.
 */
@Service
@Path("demo")
public class DemoResource {

    Map<Integer, Demo> db = new HashMap<Integer, Demo>();
    Integer idCount = 0;

    @Context
    UriInfo uriInfo;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response getDemo(@PathParam("id") Integer id) {
        if (db.containsKey(id)) {
            return Response.ok(db.get(id)).build();
        }

        throw new WebApplicationException("Demo, " + id + "not found");
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    @Produces("")
    public Response updateDemo(@PathParam("id") Integer id, Demo demo) {
        if (db.containsKey(id)) {
            demo.setId(id);
            db.put(id, demo);
            return Response.noContent().build();

        }

        throw new WebApplicationException("Demo, " + id + "not found");
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createDemo(Demo demo) {
        idCount += 1;
        demo.setId(idCount);
        db.put(idCount, demo);
        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI demoUri =  ub
                    .path(demo.getId().toString())
                    .build();

        return Response.created(demoUri).entity(demo).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response deleteDemo(@PathParam("id") Integer id) {
        if (db.containsKey(id)) {
            db.remove(id);
            return Response.ok().build();
        }

        throw new WebApplicationException("Demo, " + id + "not found");
    }

}


