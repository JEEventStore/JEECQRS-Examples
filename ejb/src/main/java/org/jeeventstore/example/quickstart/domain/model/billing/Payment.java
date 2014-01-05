package org.jeeventstore.example.quickstart.domain.model.billing;

import java.util.Date;
import org.jeecqrs.common.domain.model.AbstractEventSourcedAggregateRoot;

public final class Payment extends AbstractEventSourcedAggregateRoot<Payment, PaymentId> {

    private PaymentId paymentId;
    private InvoiceId invoiceId;
    private Date payedAt;

    public Payment(PaymentId paymentId, InvoiceId invoiceId, Date payedAt) {
        this.apply(new PaymentArrived(paymentId, invoiceId, payedAt));
    }

    @Override
    public PaymentId id() {
        return this.paymentId;
    }

    public InvoiceId invoiceId() {
        return invoiceId;
    }

    private Date payedAt() {
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
