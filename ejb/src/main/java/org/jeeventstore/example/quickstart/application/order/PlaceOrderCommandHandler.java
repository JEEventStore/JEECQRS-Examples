package org.jeeventstore.example.quickstart.application.order;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeeventstore.example.quickstart.domain.model.order.Order;
import org.jeeventstore.example.quickstart.domain.model.order.OrderRepository;
import org.jeeventstore.example.quickstart.domain.model.order.OrderService;
import org.jeeventstore.example.quickstart.domain.model.product.ProductId;

@Stateless
public class PlaceOrderCommandHandler extends AbstractCommandHandler<PlaceOrderCommand> {

    @EJB
    private OrderRepository orderRepository;

    @Inject
    private OrderService orderService;

    @Override
    public void handleCommand(PlaceOrderCommand command) {
        // translate all String representations of product ids to ProductId and place the order
        Map<ProductId, Integer> orderedProducts = new HashMap<>();
        for (Map.Entry<String, Integer> entry : command.orderedProducts().entrySet()) {
            ProductId productId = ProductId.fromString(entry.getKey());
            orderedProducts.put(productId, entry.getValue());
        }
        Order order = orderService.placeOrder(command.ordererName(), orderedProducts);
        orderRepository.add(order, command.id());
    }

}
