package org.jeeventstore.example.quickstart.domain.model.order;

import java.util.Date;
import org.jeecqrs.common.domain.model.AbstractDomainEvent;

/**
 * A new order has been placed.
 */
public final class OrderPlaced extends AbstractDomainEvent<OrderPlaced> {

    private final OrderId orderId;
    private final Date orderDate;
    private final Orderer orderer;

    public OrderPlaced(OrderId orderId, Date orderDate, Orderer orderer) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderer = orderer;
    }

    public OrderId orderId() {
        return orderId;
    }

    public Date orderDate() {
        return orderDate;
    }

    public Orderer orderer() {
        return orderer;
    }
    
}
