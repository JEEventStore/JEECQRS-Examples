package org.jeecqrs.example.quickstart.internal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeecqrs.example.quickstart.domain.model.order.Order;
import org.jeecqrs.example.quickstart.domain.model.order.OrderId;
import org.jeecqrs.example.quickstart.domain.model.order.OrderRepository;

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
