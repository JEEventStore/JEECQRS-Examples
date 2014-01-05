package org.jeeventstore.example.quickstart.sagas.orders;

import org.jeeventstore.example.quickstart.domain.model.order.OrderPlaced;

/**
 * Messages customer when an order has been placed.
 */
public class OrderPlacedMessagingSaga extends AbstractMessagingSaga<OrderPlacedMessagingSaga, OrderPlaced> {

    @Override
    protected void when(OrderPlaced event) {
        this.sendCustomerMessage(event.orderId(), "Thank you for your order.");
    }

}
