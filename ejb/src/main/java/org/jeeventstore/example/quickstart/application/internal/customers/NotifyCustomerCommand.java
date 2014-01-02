package org.jeeventstore.example.quickstart.application.internal.customers;

import org.jeecqrs.common.commands.AbstractCommand;

/**
 *
 */
public class NotifyCustomerCommand extends AbstractCommand<NotifyCustomerCommand> {

    private final String customer;
    private final String message;

    public NotifyCustomerCommand(String customer, String message) {
        this.customer = customer;
        this.message = message;
    }

    public String customer() {
        return customer;
    }

    public String message() {
        return message;
    }
    
}
