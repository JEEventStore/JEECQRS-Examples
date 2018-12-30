package org.jeecqrs.example.thorntail.domain.model.order;

import org.jeecqrs.common.domain.model.AbstractEventSourcedAggregateRoot;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Order extends AbstractEventSourcedAggregateRoot<Order, OrderId> {

    private OrderId orderId;
    private DateTime orderDate;
    private Orderer orderer;
    private final Map<OrderLineId, OrderLine> orderLines = new HashMap<>();

    private DateTime shippedAt = null;
    private String cancelReason = null;

    protected Order(OrderId orderId, DateTime orderDate, String orderer, List<OrderLine> orderLines) {
        this.apply(new OrderPlaced(orderId, orderDate, new Orderer(orderer), orderLines));
    }

    @Override
    public OrderId id() {
        return this.orderId;
    }

    public DateTime orderDate() {
        return orderDate;
    }

    public Orderer orderer() {
        return orderer;
    }

    public BigDecimal orderTotals() {
        BigDecimal sum = BigDecimal.ZERO;
        for (OrderLine ol : orderLines.values()) {
            BigDecimal quantity = new BigDecimal(ol.quantity());
            sum = sum.add(ol.pricePerItem().multiply(quantity));
        }
        return sum;
    }

    public void ship() {
        this.apply(new OrderShipped(orderId, new DateTime()));
    }

    public void cancel(String reason) {
        this.apply(new OrderCanceled(orderId, reason));
    }

    public DateTime shippedAt() {
        return this.shippedAt;
    }

    public String cancelReason() {
        return this.cancelReason;
    }

    protected void when(OrderPlaced event) {
        this.orderId = event.orderId();
        this.orderDate = event.orderDate();
        this.orderer = event.orderer();
        for (OrderLine ol : event.orderLines())
            this.orderLines.put(ol.id(), ol);
    }

    protected void when(OrderShipped event) {
        this.shippedAt = event.shippingDate();
    }

    protected void when(OrderCanceled event) {
        this.cancelReason = event.reason();
    }

    // required for repository
    private Order() { }
    
}
