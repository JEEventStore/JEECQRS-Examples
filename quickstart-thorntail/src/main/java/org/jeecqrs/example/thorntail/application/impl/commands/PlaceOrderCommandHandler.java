package org.jeecqrs.example.thorntail.application.impl.commands;

import org.jeecqrs.example.thorntail.application.api.commands.PlaceOrderCommand;
import org.jeecqrs.example.thorntail.domain.model.order.Order;
import org.jeecqrs.example.thorntail.domain.model.order.OrderRepository;
import org.jeecqrs.example.thorntail.domain.model.order.OrderService;
import org.jeecqrs.example.thorntail.domain.model.product.ProductId;
import org.jeecqrs.example.thorntail.domain.model.product.ProductRepository;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class PlaceOrderCommandHandler extends AbstractCommandHandler<PlaceOrderCommand> {

    @Inject
    private OrderRepository orderRepository;

    @Inject
    private ProductRepository productRepository;

    @Override
    public void handle(PlaceOrderCommand command) {
        // translate all String representations of product ids to ProductId and place the order
        Map<ProductId, Integer> orderedProducts = new HashMap<>();
        for (Map.Entry<String, Integer> entry : command.orderedProducts().entrySet()) {
            ProductId productId = ProductId.fromString(entry.getKey());
            orderedProducts.put(productId, entry.getValue());
        }
        OrderService orderService = new OrderService(productRepository);
        Order order = orderService.placeOrder(command.orderId(), command.ordererName(), orderedProducts);
        orderRepository.add(order, command.id());
    }

}
