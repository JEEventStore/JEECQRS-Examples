package org.jeecqrs.example.quickstart.internal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeecqrs.example.quickstart.domain.model.order.Order;
import org.jeecqrs.example.quickstart.domain.model.order.OrderId;
import org.jeecqrs.example.quickstart.domain.model.order.OrderRepository;
import org.jeecqrs.example.quickstart.domain.model.product.ProductRepository;

@Stateless
public class ShipOrderCommandHandler extends AbstractCommandHandler<ShipOrderCommand> {

    private static final Logger log = Logger.getLogger(ShipOrderCommandHandler.class.getSimpleName());

    @EJB
    private OrderRepository orderRepository;

    @EJB
    private ProductRepository productRepository;

    @Override
    public void handleCommand(ShipOrderCommand command) {
        OrderId orderId = command.orderId();
        log.log(Level.INFO, "Shipping order #{0}", command.orderId());
        Order order = orderRepository.ofIdentity(orderId);
        order.ship();
        orderRepository.save(order, command.id());
    }

}
