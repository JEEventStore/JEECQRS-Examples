package org.jeecqrs.example.quickstart.domain.model.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jeecqrs.example.quickstart.domain.model.product.Product;
import org.jeecqrs.example.quickstart.domain.model.product.ProductId;
import org.jeecqrs.example.quickstart.domain.model.product.ProductRepository;
import org.joda.time.DateTime;

public class OrderService {

    private final ProductRepository productRepository;

    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Order placeOrder(String orderer, Map<ProductId, Integer> orderedProducts) {
        List<OrderLine> orderLines = new ArrayList<>();
        BigDecimal totals = BigDecimal.ZERO;
        for (Map.Entry<ProductId, Integer> entry : orderedProducts.entrySet()) {
            ProductId productId = entry.getKey();
            Product product = productRepository.ofIdentity(productId);
            OrderLineId olid = OrderLineId.forProduct(product);
            OrderLine ol = new OrderLine(olid, productId, product.name(), product.price(), entry.getValue());
            orderLines.add(ol);
        }
        return new Order(new OrderId(), DateTime.now(), orderer, orderLines);
    }
    
}
