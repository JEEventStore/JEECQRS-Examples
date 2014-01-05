package org.jeecqrs.example.quickstart.application.order;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeecqrs.example.quickstart.domain.model.order.Order;
import org.jeecqrs.example.quickstart.domain.model.order.OrderId;
import org.jeecqrs.example.quickstart.domain.model.order.OrderRepository;

@Stateless
public class CancelOrderCommandHandler extends AbstractCommandHandler<CancelOrderCommand> {

    @EJB
    private OrderRepository orderRepository;

    @Override
    public void handleCommand(CancelOrderCommand command) {
        OrderId orderId = OrderId.fromString(command.orderId());
        Order order = orderRepository.ofIdentity(orderId);
        order.cancel(command.reason());
        orderRepository.save(order, command.id());
    }

}
