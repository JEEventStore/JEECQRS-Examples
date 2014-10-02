package org.jeecqrs.example.quickstart.domain.model.billing;

import org.jeecqrs.common.domain.model.AbstractDomainEvent;
import org.joda.time.DateTime;

/**
 * A payment for an invoice has arrived.
 */
public final class PaymentArrived extends AbstractDomainEvent<PaymentArrived> {

    private final PaymentId paymentId;
    private final InvoiceId invoiceId;
    private final DateTime payedAt;

    public PaymentArrived(PaymentId paymentId, InvoiceId invoiceId, DateTime payedAt) {
        this.paymentId = paymentId;
        this.invoiceId = invoiceId;
        this.payedAt = payedAt;
    }

    public PaymentId paymentId() {
        return paymentId;
    }

    public InvoiceId invoiceId() {
        return invoiceId;
    }

    public DateTime payedAt() {
        return payedAt;
    }

}
