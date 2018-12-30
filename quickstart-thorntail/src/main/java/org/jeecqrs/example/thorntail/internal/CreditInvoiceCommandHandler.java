package org.jeecqrs.example.thorntail.internal;

import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;

import java.util.logging.Logger;

public class CreditInvoiceCommandHandler extends AbstractCommandHandler<CreditInvoiceCommand> {

    private static final Logger log = Logger.getLogger(CreditInvoiceCommandHandler.class.getSimpleName());

    @Override
    public void handle(CreditInvoiceCommand command) {
        log.info("Credit invoice (not implemented)");
    }

}
