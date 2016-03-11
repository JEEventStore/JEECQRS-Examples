package org.jeecqrs.example.openejb.sagas.billing;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jeecqrs.integration.jcommondomain.sagas.AbstractSaga;
import org.jeecqrs.integration.jcommondomain.sagas.SagaIdentifier;
import org.jeecqrs.example.openejb.application.api.commands.CancelOrderCommand;
import org.jeecqrs.example.openejb.domain.model.billing.InvoiceId;
import org.jeecqrs.example.openejb.domain.model.billing.InvoiceIssued;
import org.jeecqrs.example.openejb.domain.model.billing.PaymentArrived;
import org.jeecqrs.example.openejb.domain.model.order.OrderId;

/**
 * Tracks invoices and cancels any orders that have not been payed
 * within the time frame.
 */
public class InvoiceTrackingSaga extends AbstractSaga<InvoiceTrackingSaga> {

    private static final Logger log = Logger.getLogger(InvoiceTrackingSaga.class.getSimpleName());

    private InvoiceId invoiceId = null;
    private OrderId orderId = null;
    private boolean completed = false; 

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
        listenTo(new SagaIdentifier<PaymentTimedOut>() {
            @Override
            public String sagaIdFor(PaymentTimedOut event) {
                return event.invoiceId().toString();
            }
        });
    }

    protected void when(InvoiceIssued event) {
        if (!eventSourceReplayActive())
            log.log(Level.INFO, "Received invoice issued event: {0}", event.invoiceId());
        this.invoiceId = event.invoiceId();
        this.orderId = event.orderId();
        if (!completed)
            // schedule timeout in 30 seconds
            this.raiseEvent(new PaymentTimedOut(invoiceId), 30000);
    }

    protected void when(PaymentArrived event) {
        if (!eventSourceReplayActive())
            log.log(Level.INFO, "Received payment arrived event #{0} for invoice #{1}",
                    new Object[]{ event.id(), event.invoiceId() });
        this.invoiceId = event.invoiceId();
        completed = true;
    }

    protected void when(PaymentTimedOut event) {
        if (!eventSourceReplayActive())
            log.log(Level.INFO, "Received payment timed out event #{0} for invoice #{1}",
                    new Object[]{ event.id(), event.invoiceId() });
        if (!isCompleted()) {
            if (!eventSourceReplayActive())
                log.log(Level.INFO, "Customer did not pay, cancel order {0}",
                        new Object[]{ orderId });
            send(new CancelOrderCommand(orderId.toString(),
                    "Customer did not pay within time"));
        } 
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

}
