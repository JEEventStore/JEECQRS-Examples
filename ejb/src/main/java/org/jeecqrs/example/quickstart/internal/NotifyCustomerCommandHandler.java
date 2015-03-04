package org.jeecqrs.example.quickstart.internal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeecqrs.example.quickstart.domain.model.order.Order;
import org.jeecqrs.example.quickstart.domain.model.order.OrderRepository;

public class NotifyCustomerCommandHandler extends AbstractCommandHandler<NotifyCustomerCommand> {

    private static final Logger log = Logger.getLogger(NotifyCustomerCommandHandler.class.getSimpleName());

    @Inject
    private OrderRepository orderRepository;

    @Override
    public void handle(NotifyCustomerCommand command) {
        Order order = orderRepository.ofIdentity(command.orderId());
        log.log(Level.INFO, "Sending out notification to customer ''{0}'': {1}",
                new Object[]{ order.orderer().name(), command.message()});
    }

}