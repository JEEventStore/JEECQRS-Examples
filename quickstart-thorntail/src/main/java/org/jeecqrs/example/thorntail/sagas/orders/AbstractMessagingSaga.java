package org.jeecqrs.example.thorntail.sagas.orders;

import org.jeecqrs.common.event.Event;
import org.jeecqrs.example.thorntail.domain.model.order.OrderId;
import org.jeecqrs.example.thorntail.internal.NotifyCustomerCommand;
import org.jeecqrs.integration.jcommondomain.sagas.AbstractSingleEventSaga;
import org.jeecqrs.sagas.Saga;

public abstract class AbstractMessagingSaga<S extends Saga<Event>, F extends Event>
        extends AbstractSingleEventSaga<S, F> {

    protected void sendCustomerMessage(OrderId orderId, String msg) {
        NotifyCustomerCommand cmd = new NotifyCustomerCommand(orderId, msg);
        this.send(cmd);
    }

}
