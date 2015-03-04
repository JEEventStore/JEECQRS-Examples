package org.jeecqrs.example.quickstart.application.order;

import javax.inject.Inject;
import org.jeecqrs.example.quickstart.domain.model.order.Order;
import org.jeecqrs.example.quickstart.domain.model.order.OrderId;
import org.jeecqrs.example.quickstart.domain.model.order.OrderRepository;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;

public class CancelOrderCommandHandler extends AbstractCommandHandler<CancelOrderCommand> {

    @Inject
    private OrderRepository orderRepository;

    @Override
    public void handle(CancelOrderCommand command) {
        OrderId orderId = OrderId.fromString(command.orderId());
        Order order = orderRepository.ofIdentity(orderId);
        order.cancel(command.reason());
        orderRepository.save(order, command.id());
    }

}
