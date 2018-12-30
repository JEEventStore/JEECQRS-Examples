package org.jeecqrs.example.thorntail.internal;

import org.jeecqrs.common.commands.AbstractCommand;
import org.jeecqrs.example.thorntail.domain.model.order.OrderId;

public final class NotifyCustomerCommand extends AbstractCommand<NotifyCustomerCommand> {

    private final OrderId orderId;
    private final String message;

    public NotifyCustomerCommand(OrderId orderId, String message) {
        this.orderId = orderId;
        this.message = message;
    }

    public OrderId orderId() {
        return orderId;
    }

    public String message() {
        return message;
    }
    
}
