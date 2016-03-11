package org.jeecqrs.example.openejb.domain.model.billing;

import java.math.BigDecimal;
import org.jeecqrs.common.domain.model.AbstractEventSourcedAggregateRoot;
import org.jeecqrs.example.openejb.domain.model.order.OrderId;
import org.joda.time.LocalDate;

public final class Invoice extends AbstractEventSourcedAggregateRoot<Invoice, InvoiceId> {

    private InvoiceId invoiceId;
    private LocalDate invoiceDate;  // example for custom serialization converter
    private OrderId orderId;
    private String buyer;
    private String text;
    private BigDecimal totals;

    protected Invoice(InvoiceId invoiceId, LocalDate invoiceDate, OrderId orderId,
            String buyer, String text, BigDecimal totals) {
        this.apply(new InvoiceIssued(invoiceId, invoiceDate, orderId, buyer, text, totals));
    }

    @Override
    public InvoiceId id() {
        return this.invoiceId;
    }

    public BigDecimal totals() {
        return this.totals;
    }

    protected void when(InvoiceIssued event) {
        this.invoiceId = event.invoiceId();
        this.invoiceDate = event.invoiceDate();
        this.buyer = event.buyer();
        this.text = event.text();
        this.totals = event.totals();
    }

    // required for repository
    private Invoice() { }
    
}
