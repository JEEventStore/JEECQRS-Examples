package org.jeecqrs.example.openejb.sagas.orders;

import org.jeecqrs.example.openejb.domain.model.billing.InvoiceIssued;
import org.jeecqrs.example.openejb.domain.model.billing.PaymentArrived;
import org.jeecqrs.example.openejb.domain.model.order.OrderId;
import org.jeecqrs.example.openejb.internal.ShipOrderCommand;
import org.jeecqrs.integration.jcommondomain.sagas.AbstractSaga;
import org.jeecqrs.integration.jcommondomain.sagas.SagaIdentifier;

/**
 * Ship an order when an invoice for the order has been created
 * and the corresponding invoice has been payed.
 */
public class OrderShipmentSaga extends AbstractSaga<OrderShipmentSaga> {

    private OrderId orderId = null;
    private boolean payed = false;

    @Override
    protected void setupSaga() {
        listenTo((SagaIdentifier<InvoiceIssued>) event -> event.invoiceId().toString());
        listenTo((SagaIdentifier<PaymentArrived>) event -> event.invoiceId().toString());
    }

    protected void when(InvoiceIssued event) {
        this.orderId = event.orderId();
        shipOrderOnCompletion();
    }

    protected void when(PaymentArrived event) {
        this.payed = true;
        shipOrderOnCompletion();
    }

    private void shipOrderOnCompletion() {
        if (isCompleted())
            send(new ShipOrderCommand(orderId));
    }

    @Override
    public boolean isCompleted() {
        return payed && orderId != null;
    }
   
}
