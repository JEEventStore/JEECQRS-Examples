package org.jeeventstore.example.quickstart.application.internal.customers;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.jeecqrs.command.CommandHandler;

/**
 *
 */
@Stateless
public class NotifyCustomerCommandHandler implements CommandHandler<NotifyCustomerCommand> {

    private Logger log = Logger.getAnonymousLogger();

    @Override
    public void handleCommand(NotifyCustomerCommand command) {
        log.info("Sending out notification to customer '" + command.customer() + "': " + command.message());
    }

    @Override
    public Class<? extends NotifyCustomerCommand> handledCommandType() {
        return NotifyCustomerCommand.class;
    }
    
}