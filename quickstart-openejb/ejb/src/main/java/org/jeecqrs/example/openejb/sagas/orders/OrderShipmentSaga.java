package org.jeecqrs.example.openejb.sagas.orders;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.inject.Inject;
import org.jeecqrs.common.sagas.SagaCommandBus;
import org.jeecqrs.common.sagas.SagaTimeoutProvider;
import org.jeecqrs.integration.jcommondomain.sagas.AbstractSaga;
import org.jeecqrs.integration.jcommondomain.sagas.SagaIdentifier;
import org.jeecqrs.example.openejb.internal.ShipOrderCommand;
import org.jeecqrs.example.openejb.domain.model.billing.InvoiceIssued;
import org.jeecqrs.example.openejb.domain.model.billing.PaymentArrived;
import org.jeecqrs.example.openejb.domain.model.order.OrderId;

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
