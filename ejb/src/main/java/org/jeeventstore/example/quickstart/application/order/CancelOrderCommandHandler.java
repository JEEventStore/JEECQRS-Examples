package org.jeeventstore.example.quickstart.application.order;

import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.command.CommandHandler;
import org.jeeventstore.example.quickstart.domain.model.order.Order;
import org.jeeventstore.example.quickstart.domain.model.order.OrderId;
import org.jeeventstore.example.quickstart.domain.model.order.OrderRepository;
import org.jeeventstore.example.quickstart.domain.model.product.Product;
import org.jeeventstore.example.quickstart.domain.model.product.ProductId;
import org.jeeventstore.example.quickstart.domain.model.product.ProductRepository;

/**
 *
 */
@Stateless
public class PlaceOrderCommandHandler implements CommandHandler<PlaceOrderCommand> {

    private Logger log = Logger.getAnonymousLogger();

    @EJB
    private OrderRepository orderRepository;

    @EJB
    private ProductRepository productRepository;

    @Override
    public void handleCommand(PlaceOrderCommand command) {
        log.info("Received PlaceOrderCommand");
        Order order = new Order(new OrderId(), new Date(), command.ordererName());
        for (Map.Entry<String, Integer> entry : command.orderedProducts().entrySet()) {
            ProductId productId = ProductId.fromString(entry.getKey());
            log.info("Lade Product: " + productId);
            Product product = productRepository.productOfIdentity(productId);
            log.info("Product gefunden: " + product);
            order.addOrderLine(product, entry.getValue());
        }
        log.info("Adding new order to repository");
        orderRepository.add(order, command.id().idString());
        log.info("command handled");
    }

    @Override
    public Class<? extends PlaceOrderCommand> handledCommandType() {
        return PlaceOrderCommand.class;
    }
    
}
