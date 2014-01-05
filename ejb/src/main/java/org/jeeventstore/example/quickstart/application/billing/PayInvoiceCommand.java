package org.jeeventstore.example.quickstart.application.billing;

import org.jeeventstore.example.quickstart.application.order.*;
import org.jeecqrs.common.commands.AbstractCommand;

public final class PayInvoiceCommand extends AbstractCommand<CancelOrderCommand> {

    private final String invoiceId;

    public PayInvoiceCommand(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String invoiceId() {
        return this.invoiceId;
    }

}
