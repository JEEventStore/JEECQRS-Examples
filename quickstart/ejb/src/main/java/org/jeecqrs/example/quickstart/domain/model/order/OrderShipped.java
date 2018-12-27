package org.jeecqrs.example.quickstart.domain.model.order;

import org.jeecqrs.common.domain.model.AbstractDomainEvent;
import org.joda.time.DateTime;

/**
 * A new order has been placed.
 */
public final class OrderShipped extends AbstractDomainEvent<OrderShipped> {

    private final OrderId orderId;
    private final DateTime shippingDate;

    public OrderShipped(OrderId orderId, DateTime shippingDate) {
        this.orderId = orderId;
        this.shippingDate = shippingDate;
    }

    public OrderId orderId() {
        return orderId;
    }

    public DateTime shippingDate() {
        return shippingDate;
    }
    
}
