package org.jeecqrs.example.openejb.sagas.orders;

import org.jeecqrs.example.openejb.domain.model.order.OrderPlaced;

/**
 * Messages customer when an order has been placed.
 */
public class OrderPlacedMessagingSaga extends AbstractMessagingSaga<OrderPlacedMessagingSaga, OrderPlaced> {

    @Override
    protected void when(OrderPlaced event) {
        this.sendCustomerMessage(event.orderId(), "Thank you for your order.");
    }

}
