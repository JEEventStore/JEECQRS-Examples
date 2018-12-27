package org.jeecqrs.example.openejb.domain.model.billing;

import org.jeecqrs.common.domain.model.AbstractEventSourcedAggregateRoot;
import org.joda.time.DateTime;

public final class Payment extends AbstractEventSourcedAggregateRoot<Payment, PaymentId> {

    private PaymentId paymentId;
    private InvoiceId invoiceId;
    private DateTime payedAt;

    public Payment(PaymentId paymentId, InvoiceId invoiceId, DateTime payedAt) {
        this.apply(new PaymentArrived(paymentId, invoiceId, payedAt));
    }

    @Override
    public PaymentId id() {
        return this.paymentId;
    }

    public InvoiceId invoiceId() {
        return invoiceId;
    }

    private DateTime payedAt() {
        return this.payedAt;
    }

    protected void when(PaymentArrived event) {
        this.paymentId = event.paymentId();
        this.invoiceId = event.invoiceId();
        this.payedAt = event.payedAt();
    }

    // required for repository
    private Payment() { }
    
}
