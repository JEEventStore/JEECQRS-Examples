package org.jeeventstore.example.quickstart.domain.model.order;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jeecqrs.common.domain.model.AbstractEventSourcedAggregateRoot;
import org.jeecqrs.common.util.Validate;
import org.jeeventstore.example.quickstart.domain.model.product.Product;

/**
 *
 */
public final class Order extends AbstractEventSourcedAggregateRoot<Order> {

    private OrderId orderId;
    private Date orderDate;
    private Orderer orderer;
    private String cancelReason;

    private final Map<OrderLineId, OrderLine> orderLines = new HashMap<>();

    public Order(OrderId orderId, Date orderDate, String orderer) {
        this.apply(new OrderPlaced(orderId, orderDate, new Orderer(orderer)));
    }

    @Override
    public OrderId id() {
        return this.orderId;
    }

    public Date orderDate() {
        return orderDate;
    }

    public Orderer orderer() {
        return orderer;
    }

    public void cancel(String reason) {
        this.apply(new OrderCanceled(orderId, reason));
    }

    public boolean isCanceled() {
        return cancelReason != null;
    }

    public String cancelReason() {
        return this.cancelReason;
    }

    public void addOrderLine(Product product, int quantity) {
        if (product == null)
            throw new NullPointerException("product must not be null");
        OrderLineId olid = OrderLineId.forProduct(product);
        if (orderLines.containsKey(olid))
            throw new IllegalArgumentException("Duplicate order for product " + product.id().idString());
        this.apply(new OrderLineAdded(olid, product.id(), product.name(),
                product.price(), quantity));
    }

    protected void when(OrderPlaced event) {
        this.orderId = event.orderId();
        this.orderDate = event.orderDate();
        this.orderer = event.orderer();
    }

    protected void when(OrderLineAdded event) {
        OrderLineId olid = event.lineId();
        OrderLine ol = new OrderLine(olid, event.productId(), event.productName(),
                event.pricePerItem(), event.quantity());
        this.orderLines.put(olid, ol);
    }

    protected void when(OrderCanceled event) {
        this.cancelReason = event.reason();
    }

    // required for repository
    private Order() { }
    
}
