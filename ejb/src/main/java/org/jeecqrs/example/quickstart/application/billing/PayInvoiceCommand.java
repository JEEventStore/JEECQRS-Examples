package org.jeecqrs.example.quickstart.application.billing;

import org.jeecqrs.common.commands.AbstractCommand;
import org.jeecqrs.example.quickstart.application.order.CancelOrderCommand;

public final class PayInvoiceCommand extends AbstractCommand<CancelOrderCommand> {

    private final String invoiceId;

    public PayInvoiceCommand(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String invoiceId() {
        return this.invoiceId;
    }

}
