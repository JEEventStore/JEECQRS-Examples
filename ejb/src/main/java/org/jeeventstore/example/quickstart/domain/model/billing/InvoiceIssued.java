package org.jeeventstore.example.quickstart.domain.model.billing;

import java.math.BigDecimal;
import org.jeeventstore.example.quickstart.domain.model.order.*;
import org.jeecqrs.common.domain.model.AbstractDomainEvent;
import org.joda.time.LocalDate;

/**
 * A new invoice has been issued.
 */
public final class InvoiceIssued extends AbstractDomainEvent<InvoiceIssued> {

    private final InvoiceId invoiceId;
    private final LocalDate invoiceDate;
    private final OrderId orderId;
    private final String buyer;
    private final String text;
    private final BigDecimal totals;

    public InvoiceIssued(InvoiceId invoiceId, LocalDate invoiceDate,
            OrderId orderId, String buyer, String text, BigDecimal totals) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.orderId = orderId;
        this.buyer = buyer;
        this.text = text;
        this.totals = totals;
    }

    public InvoiceId invoiceId() {
        return invoiceId;
    }

    public LocalDate invoiceDate() {
        return invoiceDate;
    }

    public OrderId orderId() {
        return orderId;
    }

    public String buyer() {
        return buyer;
    }

    public String text() {
        return text;
    }

    public BigDecimal totals() {
        return totals;
    }

}
