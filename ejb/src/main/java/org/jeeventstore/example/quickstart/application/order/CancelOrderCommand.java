package org.jeeventstore.example.quickstart.application.order;

import org.jeecqrs.common.commands.AbstractCommand;

public final class CancelOrderCommand extends AbstractCommand<CancelOrderCommand> {

    private final String orderId;
    private final String reason;

    public CancelOrderCommand(String orderId, String reason) {
        this.orderId = orderId;
        this.reason = reason;
    }

    public String orderId() {
        return this.orderId;
    }

    public String reason() {
        return reason;
    }

}
