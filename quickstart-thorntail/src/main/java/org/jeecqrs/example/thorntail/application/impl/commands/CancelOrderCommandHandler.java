package org.jeecqrs.example.thorntail.application.impl.commands;

import org.jeecqrs.example.thorntail.application.api.commands.CancelOrderCommand;
import org.jeecqrs.example.thorntail.domain.model.order.Order;
import org.jeecqrs.example.thorntail.domain.model.order.OrderId;
import org.jeecqrs.example.thorntail.domain.model.order.OrderRepository;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;

import javax.inject.Inject;

public class CancelOrderCommandHandler extends AbstractCommandHandler<CancelOrderCommand> {

    @Inject
    private OrderRepository orderRepository;

    @Override
    public void handle(CancelOrderCommand command) {
        OrderId orderId = command.orderId();
        Order order = orderRepository.ofIdentity(orderId);
        order.cancel(command.reason());
        orderRepository.save(order, command.id());
    }

}
