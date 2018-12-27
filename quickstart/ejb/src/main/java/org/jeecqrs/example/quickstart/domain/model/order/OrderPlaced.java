package org.jeecqrs.example.quickstart.domain.model.order;

import java.util.Collections;
import java.util.List;
import org.jeecqrs.common.domain.model.AbstractDomainEvent;
import org.joda.time.DateTime;

/**
 * A new order has been placed.
 */
public final class OrderPlaced extends AbstractDomainEvent<OrderPlaced> {

    private final OrderId orderId;
    private final DateTime orderDate;
    private final Orderer orderer;
    private final List<OrderLine> orderLines;

    public OrderPlaced(OrderId orderId, DateTime orderDate, Orderer orderer, List<OrderLine> orderLines) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderer = orderer;
        this.orderLines = orderLines;
    }

    public OrderId orderId() {
        return orderId;
    }

    public DateTime orderDate() {
        return orderDate;
    }

    public Orderer orderer() {
        return orderer;
    }

    public List<OrderLine> orderLines() {
        return Collections.unmodifiableList(orderLines);
    }

}
