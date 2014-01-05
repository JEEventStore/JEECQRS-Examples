package org.jeecqrs.example.quickstart.sagas.orders;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jeecqrs.integration.jcommondomain.sagas.AbstractSaga;
import org.jeecqrs.integration.jcommondomain.sagas.SagaIdentifier;
import org.jeecqrs.example.quickstart.internal.CreateInvoiceForOrderCommand;
import org.jeecqrs.example.quickstart.internal.CreditInvoiceCommand;
import org.jeecqrs.example.quickstart.domain.model.billing.InvoiceId;
import org.jeecqrs.example.quickstart.domain.model.billing.InvoiceIssued;
import org.jeecqrs.example.quickstart.domain.model.order.OrderCanceled;
import org.jeecqrs.example.quickstart.domain.model.order.OrderPlaced;
import org.jeecqrs.example.quickstart.domain.model.order.OrderShipped;

/**
 * Tracks invoices for orders.
 * Creates and invoice for new orders, and credits the invoice when the
 * corresponding order has been canceled.
 */
public class OrderInvoiceTrackingSaga extends AbstractSaga<OrderInvoiceTrackingSaga> {

    private static final Logger log = Logger.getLogger(OrderInvoiceTrackingSaga.class.getSimpleName());

    private InvoiceId invoiceId = null;
    private boolean canceled = false;
    private boolean completed = false;

    @Override
    protected void setupSaga() {
        listenTo(new SagaIdentifier<OrderPlaced>() {
            @Override
            public String sagaIdFor(OrderPlaced event) {
                return event.orderId().toString();
            }
        });
        listenTo(new SagaIdentifier<OrderCanceled>() {
            @Override
            public String sagaIdFor(OrderCanceled event) {
                return event.orderId().toString();
            }
        });
        listenTo(new SagaIdentifier<OrderShipped>() {
            @Override
            public String sagaIdFor(OrderShipped event) {
                return event.orderId().toString();
            }
        });
        listenTo(new SagaIdentifier<InvoiceIssued>() {
            @Override
            public String sagaIdFor(InvoiceIssued event) {
                return event.orderId().toString();
            }
        });
    }

    protected void when(OrderPlaced event) {
        if (!eventSourceReplayActive())
            log.log(Level.INFO, "Received order placed event for order #{0}", event.orderId());
        this.executeCommand(new CreateInvoiceForOrderCommand(event.orderId()));
    }

    protected void when(OrderCanceled event) {
        if (!eventSourceReplayActive())
            log.log(Level.INFO, "Received order canceled event for order #{0}, invoice #{1}",
                    new Object[]{ event.orderId(), invoiceId });
        this.canceled = true;
        // event can arrive before InvoiceIssue has arrived
        cancelInvoiceWhenNeeded();
    }

    protected void when(OrderShipped event) {
        if (!eventSourceReplayActive())
            log.log(Level.INFO, "Received order shipped event for order #{0}", event.orderId());
        this.completed = true;
    }

    protected void when(InvoiceIssued event) {
        if (!eventSourceReplayActive())
            log.log(Level.INFO, "Received invoice issued event for order #{0}, invoice #{1}",
                    new Object[]{ event.orderId(), event.invoiceId() });
        this.invoiceId = event.invoiceId();
        // event can arrive after OrderCanceled has arrived
        cancelInvoiceWhenNeeded();
    }

    private void cancelInvoiceWhenNeeded() {
        if (completed || !canceled || invoiceId == null)
            return;
        this.executeCommand(new CreditInvoiceCommand(invoiceId));
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }
    
}
