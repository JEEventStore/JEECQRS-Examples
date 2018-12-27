package org.jeecqrs.example.openejb.internal;

import java.util.logging.Logger;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;

public class CreditInvoiceCommandHandler extends AbstractCommandHandler<CreditInvoiceCommand> {

    private static final Logger log = Logger.getLogger(CreditInvoiceCommandHandler.class.getSimpleName());

    @Override
    public void handle(CreditInvoiceCommand command) {
        log.info("Credit invoice (not implemented)");
    }

}
