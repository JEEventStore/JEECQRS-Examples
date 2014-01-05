package org.jeecqrs.example.quickstart.domain.model.billing;

import java.util.Date;
import org.jeecqrs.common.domain.model.AbstractDomainEvent;

/**
 * A payment for an invoice has arrived.
 */
public final class PaymentArrived extends AbstractDomainEvent<PaymentArrived> {

    private final PaymentId paymentId;
    private final InvoiceId invoiceId;
    private final Date payedAt;

    public PaymentArrived(PaymentId paymentId, InvoiceId invoiceId, Date payedAt) {
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

    public Date payedAt() {
        return payedAt;
    }

}
