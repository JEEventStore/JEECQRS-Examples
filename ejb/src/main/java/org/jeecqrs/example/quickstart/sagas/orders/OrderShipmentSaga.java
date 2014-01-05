package org.jeecqrs.example.quickstart.sagas.orders;

import org.jeecqrs.integration.jcommondomain.sagas.AbstractSaga;
import org.jeecqrs.integration.jcommondomain.sagas.SagaIdentifier;
import org.jeecqrs.example.quickstart.internal.ShipOrderCommand;
import org.jeecqrs.example.quickstart.domain.model.billing.InvoiceIssued;
import org.jeecqrs.example.quickstart.domain.model.billing.PaymentArrived;
import org.jeecqrs.example.quickstart.domain.model.order.OrderId;

/**
 * Ship an order when an invoice for the order has been created
 * and the corresponding invoice has been payed.
 */
public class OrderShipmentSaga extends AbstractSaga<OrderShipmentSaga> {

    private OrderId orderId = null;
    private boolean payed = false;

    @Override
    protected void setupSaga() {
        listenTo(new SagaIdentifier<InvoiceIssued>() {
            @Override
            public String sagaIdFor(InvoiceIssued event) {
                return event.invoiceId().toString();
            }
        });
        listenTo(new SagaIdentifier<PaymentArrived>() {
            @Override
            public String sagaIdFor(PaymentArrived event) {
                return event.invoiceId().toString();
            }
        });
    }

    protected void when(InvoiceIssued event) {
        this.orderId = event.orderId();
        checkCompletion();
    }

    protected void when(PaymentArrived event) {
        this.payed = true;
        checkCompletion();
    }

    private void checkCompletion() {
        if (isCompleted())
            executeCommand(new ShipOrderCommand(orderId));
    }

    @Override
    public boolean isCompleted() {
        return payed && orderId != null;
    }
   
}
