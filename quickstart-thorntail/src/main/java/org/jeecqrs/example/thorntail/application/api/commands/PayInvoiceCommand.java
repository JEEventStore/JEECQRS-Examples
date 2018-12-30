package org.jeecqrs.example.thorntail.application.api.commands;

import org.jeecqrs.common.commands.AbstractCommand;
import org.jeecqrs.example.thorntail.domain.model.billing.InvoiceId;

public final class PayInvoiceCommand extends AbstractCommand<PayInvoiceCommand> {

    private final InvoiceId invoiceId;

    public PayInvoiceCommand(InvoiceId invoiceId) {
        this.invoiceId = invoiceId;
    }

    public InvoiceId invoiceId() {
        return this.invoiceId;
    }

}
