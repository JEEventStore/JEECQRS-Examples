package org.jeecqrs.example.thorntail.application.impl.queries;

import org.jeecqrs.common.event.Event;
import org.jeecqrs.example.thorntail.application.api.queries.OrderBean;
import org.jeecqrs.example.thorntail.domain.model.order.OrderCanceled;
import org.jeecqrs.example.thorntail.domain.model.order.OrderPlaced;
import org.jeecqrs.example.thorntail.domain.model.order.OrderShipped;
import org.jeecqrs.integration.jcommondomain.projections.AbstractProjection;

import javax.inject.Inject;

public class OrderQueryProjection extends AbstractProjection {

    @Inject
    private OrderQueryDataStore ds;

    @Override
    protected Class<? extends Event>[] listenToEvents() {
        return new Class[] {
            OrderPlaced.class,
            OrderCanceled.class,
            OrderShipped.class,
        };
    }

    protected void when(OrderPlaced event) {
        ds.put(new OrderBean(event.orderId().toString(), event.orderDate().toDate(),
                event.orderer().name()));
    }

    // each projection is receiving orders single-threaded, so we can be sure the
    // following does not result in concurrent modifications.

    protected void when(OrderShipped event) {
        OrderBean bean = ds.get(event.orderId().toString());
        bean.ship();
        ds.put(bean);
    }

    protected void when(OrderCanceled event) {
        OrderBean bean = ds.get(event.orderId().toString());
        bean.cancel();
        ds.put(bean);
    }
    
}
