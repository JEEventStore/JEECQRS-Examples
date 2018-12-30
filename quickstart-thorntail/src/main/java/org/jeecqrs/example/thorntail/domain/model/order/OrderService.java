package org.jeecqrs.example.thorntail.domain.model.order;

import org.jeecqrs.example.thorntail.domain.model.product.Product;
import org.jeecqrs.example.thorntail.domain.model.product.ProductId;
import org.jeecqrs.example.thorntail.domain.model.product.ProductRepository;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OrderService {

    private final ProductRepository productRepository;

    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Order placeOrder(OrderId orderId, String orderer, Map<ProductId, Integer> orderedProducts) {
        List<OrderLine> orderLines = new ArrayList<>();
        for (Map.Entry<ProductId, Integer> entry : orderedProducts.entrySet()) {
            ProductId productId = entry.getKey();
            Product product = productRepository.ofIdentity(productId);
            OrderLineId olid = OrderLineId.forProduct(product);
            OrderLine ol = new OrderLine(olid, productId, product.name(), product.price(), entry.getValue());
            orderLines.add(ol);
        }
        return new Order(orderId, new DateTime(), orderer, orderLines);
    }
    
}
