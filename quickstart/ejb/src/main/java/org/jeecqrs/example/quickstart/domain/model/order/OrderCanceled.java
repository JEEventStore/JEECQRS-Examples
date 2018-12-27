package org.jeecqrs.example.quickstart.domain.model.order;

import org.jeecqrs.common.domain.model.AbstractDomainEvent;

/**
 * An order has been canceled.
 */
public final class OrderCanceled extends AbstractDomainEvent<OrderCanceled> {

    private final OrderId orderId;
    private final String reason;

    public OrderCanceled(OrderId orderId, String reason) {
        this.orderId = orderId;
        this.reason = reason;
    }

    public OrderId orderId() {
        return orderId;
    }

    public String reason() {
        return reason;
    }
    
}
