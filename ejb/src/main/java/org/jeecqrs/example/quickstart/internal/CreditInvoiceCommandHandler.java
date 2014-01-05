package org.jeecqrs.example.quickstart.internal;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;

@Stateless
public class CreditInvoiceCommandHandler extends AbstractCommandHandler<CreditInvoiceCommand> {

    private static final Logger log = Logger.getLogger(CreditInvoiceCommandHandler.class.getSimpleName());

    @Override
    public void handleCommand(CreditInvoiceCommand command) {
        log.info("Credit invoice (not implemented)");
    }

}
