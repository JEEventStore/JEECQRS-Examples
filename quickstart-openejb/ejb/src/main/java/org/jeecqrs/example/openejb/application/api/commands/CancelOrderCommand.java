package org.jeecqrs.example.openejb.application.api.commands;

import org.jeecqrs.common.commands.AbstractCommand;
import org.jeecqrs.example.openejb.domain.model.order.OrderId;

public final class CancelOrderCommand extends AbstractCommand<CancelOrderCommand> {

    private final OrderId orderId;
    private final String reason;

    public CancelOrderCommand(OrderId orderId, String reason) {
        this.orderId = orderId;
        this.reason = reason;
    }

    public OrderId orderId() {
        return this.orderId;
    }

    public String reason() {
        return reason;
    }

}
