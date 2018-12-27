package org.jeecqrs.example.quickstart.internal;

import org.jeecqrs.common.commands.AbstractCommand;
import org.jeecqrs.example.quickstart.domain.model.billing.InvoiceId;

public final class CreditInvoiceCommand extends AbstractCommand<CreditInvoiceCommand> {

    private final InvoiceId invoiceId;

    public CreditInvoiceCommand(InvoiceId invoiceId) {
        this.invoiceId = invoiceId;
    }

    public InvoiceId invoiceId() {
        return invoiceId;
    }
    
}
