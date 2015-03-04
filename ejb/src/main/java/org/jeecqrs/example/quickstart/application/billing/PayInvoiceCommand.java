package org.jeecqrs.example.quickstart.application.billing;

import org.jeecqrs.common.commands.AbstractCommand;

public final class PayInvoiceCommand extends AbstractCommand<PayInvoiceCommand> {

    private final String invoiceId;

    public PayInvoiceCommand(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String invoiceId() {
        return this.invoiceId;
    }

}
