package org.jeecqrs.example.openejb.sagas.billing;

import org.jeecqrs.common.event.AbstractEvent;
import org.jeecqrs.example.openejb.domain.model.billing.InvoiceId;

public final class PaymentTimedOut extends AbstractEvent<PaymentTimedOut> {

    private final InvoiceId invoiceId;

    public PaymentTimedOut(InvoiceId invoiceId) {
        this.invoiceId = invoiceId;
    }

    public InvoiceId invoiceId() {
        return invoiceId;
    }
    
}
