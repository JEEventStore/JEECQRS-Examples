package org.jeecqrs.example.openejb.application.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.jeecqrs.example.openejb.application.api.LoadFixtures;
import org.jeecqrs.example.openejb.application.api.queries.ProductQuery;

@Path("/products")
@Stateless
@CrossOriginResourceSharing(
        allowOrigins = { "*" }
)
public class ProductResource {

    @Inject
    private ProductQuery pq;

    @Inject
    private LoadFixtures loadFixtures;

    @POST
    @Path("/load")
    @Produces("application/json")
    public Response load() {
        loadFixtures.load();
        return Response.ok().build();
    }

    @GET
    @Produces("application/json")
    public Response list() {
        return Response.ok().entity(pq.listProducts()).build();
    }
    
}
