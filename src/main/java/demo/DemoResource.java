package demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.net.URI;


/**
 * Created by Anthony on 5/20/16.
 */
@Service
@Path("demo")
@Api(value = "Demo resource", produces = "application/json")
public class DemoResource {

    @Context
    UriInfo uriInfo;

    @Autowired
    DemoRepository demoRepository;

    @GET
    @Path("{id}")
    @Produces("application/json")
    @ApiOperation(value = "Gets a demo resource. Version 1 - (version in URL)", response = Demo.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "hello resource found"),
            @ApiResponse(code = 404, message = "Given admin user not found")
    })
    public Response getDemo(@PathParam("id") String id) {
            Demo demo = demoRepository.findOne(id);
            if (demo != null) {
                return Response.ok(demo).build();
            }

        throw new WebApplicationException("Demo, " + id + "not found");
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public Response updateDemo(@PathParam("id") Integer id, Demo demo) {

            demoRepository.save(demo);
            return Response.noContent().build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response createDemo(Demo demo) {
        Demo savedDemo = demoRepository.save(demo);
        UriBuilder ub = uriInfo.getAbsolutePathBuilder();
        URI demoUri =  ub
                    .path(savedDemo.getId().toString())
                    .build();

        return Response.created(demoUri).entity(savedDemo).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response deleteDemo(@PathParam("id") String id) {
        if (demoRepository.findOne(id) != null) {
            demoRepository.delete(id);
            return Response.ok().build();
        }

        throw new WebApplicationException("Demo, " + id + "not found");
    }

}


