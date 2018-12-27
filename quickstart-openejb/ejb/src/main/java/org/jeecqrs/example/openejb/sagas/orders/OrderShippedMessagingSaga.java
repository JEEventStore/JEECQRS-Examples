package org.jeecqrs.example.openejb.sagas.orders;

import org.jeecqrs.example.openejb.domain.model.order.OrderShipped;

/**
 * Messages customer when an order has been placed.
 */
public class OrderShippedMessagingSaga extends AbstractMessagingSaga<OrderShippedMessagingSaga, OrderShipped> {

    @Override
    protected void when(OrderShipped event) {
        this.sendCustomerMessage(event.orderId(), "Your order has been shipped.");
    }

}
