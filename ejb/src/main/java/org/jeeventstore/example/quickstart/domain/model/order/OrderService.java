package org.jeeventstore.example.quickstart.domain.model.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import org.jeeventstore.example.quickstart.domain.model.product.Product;
import org.jeeventstore.example.quickstart.domain.model.product.ProductId;
import org.jeeventstore.example.quickstart.domain.model.product.ProductRepository;

public class OrderService {

    @EJB
    private ProductRepository productRepository;

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
        return new Order(new OrderId(), new Date(), orderer, orderLines);
    }
    
}
