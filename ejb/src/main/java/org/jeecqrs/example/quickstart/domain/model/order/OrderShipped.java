package org.jeecqrs.example.quickstart.domain.model.order;

import java.util.Date;
import org.jeecqrs.common.domain.model.AbstractDomainEvent;

/**
 * A new order has been placed.
 */
public final class OrderShipped extends AbstractDomainEvent<OrderShipped> {

    private final OrderId orderId;
    private final Date shippingDate;

    public OrderShipped(OrderId orderId, Date shippingDate) {
        this.orderId = orderId;
        this.shippingDate = shippingDate;
    }

    public OrderId orderId() {
        return orderId;
    }

    public Date shippingDate() {
        return shippingDate;
    }
    
}
