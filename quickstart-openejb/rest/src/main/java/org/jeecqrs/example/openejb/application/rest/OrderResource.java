package org.jeecqrs.example.openejb.application.rest;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.jeecqrs.common.commands.CommandBus;
import org.jeecqrs.example.openejb.application.api.commands.PlaceOrderCommand;
import org.jeecqrs.example.openejb.application.api.queries.OrderBean;
import org.jeecqrs.example.openejb.application.api.queries.OrderQuery;
import org.jeecqrs.example.openejb.domain.model.order.OrderId;

@Path("/orders")
@Stateless
@CrossOriginResourceSharing(
        allowAllOrigins = true
)
public class OrderResource {

    @Inject
    private CommandBus commandBus;

    @Context
    private UriInfo uriInfo;

    @Inject
    private OrderQuery oq;

    @POST
    @Produces("application/json")
    public Response placeOrder(OrderRequestBean order) {
        OrderId orderId = new OrderId();
        PlaceOrderCommand cmd;
        try {
            cmd = new PlaceOrderCommand(orderId, order.getCustomerName(), order.ordersAsMap());
        } catch (NullPointerException | IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        commandBus.send(cmd);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(orderId.toString());
        return Response.created(builder.build()).build();
    }

    @GET
    @Path("{orderId}")
    @Produces("application/json")
    public Response getOrder(@PathParam("orderId") String orderId) {
        OrderBean ob = oq.getOrder(orderId);
        if (ob == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok().entity(ob).build();
    }
    
}
