package org.jeecqrs.example.quickstart.sagas.orders;

import org.jeecqrs.example.quickstart.domain.model.order.OrderCanceled;

/**
 * Messages customer when an order has been placed.
 */
public class OrderCanceledMessagingSaga extends AbstractMessagingSaga<OrderCanceledMessagingSaga, OrderCanceled> {

    @Override
    protected void when(OrderCanceled event) {
        this.sendCustomerMessage(event.orderId(), "Your order has been canceled: " + event.reason());
    }

}
