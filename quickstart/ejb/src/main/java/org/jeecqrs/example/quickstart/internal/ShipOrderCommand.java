package org.jeecqrs.example.quickstart.internal;

import org.jeecqrs.common.commands.AbstractCommand;
import org.jeecqrs.example.quickstart.domain.model.order.OrderId;

public final class ShipOrderCommand extends AbstractCommand<ShipOrderCommand> {

    private final OrderId orderId;

    public ShipOrderCommand(OrderId orderId) {
        this.orderId = orderId;
    }

    public OrderId orderId() {
        return this.orderId;
    }

}
