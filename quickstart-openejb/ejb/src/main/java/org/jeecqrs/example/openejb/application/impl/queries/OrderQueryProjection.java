package org.jeecqrs.example.openejb.application.impl.queries;

import org.jeecqrs.example.openejb.application.api.queries.OrderBean;
import javax.inject.Inject;
import org.jeecqrs.common.event.Event;
import org.jeecqrs.example.openejb.domain.model.order.OrderCanceled;
import org.jeecqrs.example.openejb.domain.model.order.OrderPlaced;
import org.jeecqrs.example.openejb.domain.model.order.OrderShipped;
import org.jeecqrs.integration.jcommondomain.projections.AbstractProjection;

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
