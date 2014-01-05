package org.jeecqrs.example.quickstart.internal;

import org.jeecqrs.common.commands.AbstractCommand;
import org.jeecqrs.example.quickstart.domain.model.order.OrderId;

public final class CreateInvoiceForOrderCommand extends AbstractCommand<CreateInvoiceForOrderCommand> {

    private final OrderId orderId;

    public CreateInvoiceForOrderCommand(OrderId orderId) {
        this.orderId = orderId;
    }

    public OrderId orderId() {
        return orderId;
    }
    
}
