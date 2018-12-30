package org.jeecqrs.example.thorntail.internal;

import org.jeecqrs.example.thorntail.domain.model.order.Order;
import org.jeecqrs.example.thorntail.domain.model.order.OrderId;
import org.jeecqrs.example.thorntail.domain.model.order.OrderRepository;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;

import javax.inject.Inject;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShipOrderCommandHandler extends AbstractCommandHandler<ShipOrderCommand> {

    private static final Logger log = Logger.getLogger(ShipOrderCommandHandler.class.getSimpleName());

    @Inject
    private OrderRepository orderRepository;

    @Override
    public void handle(ShipOrderCommand command) {
        OrderId orderId = command.orderId();
        log.log(Level.INFO, "Shipping order #{0}", command.orderId());
        Order order = orderRepository.ofIdentity(orderId);
        order.ship();
        orderRepository.save(order, command.id());
    }

}
