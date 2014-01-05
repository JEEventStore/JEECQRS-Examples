package org.jeeventstore.example.quickstart.domain.model.order;

import org.jeecqrs.common.AbstractId;

/**
 * Uniquely identifies an order.
 */
public final class OrderId extends AbstractId<OrderId> {

    public OrderId() { }

    private OrderId(String orderId) {
        super(orderId);
    }

    public static OrderId fromString(String orderId) {
        return new OrderId(orderId);
    }

}
