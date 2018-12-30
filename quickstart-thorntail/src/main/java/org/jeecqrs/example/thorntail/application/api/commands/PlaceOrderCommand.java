package org.jeecqrs.example.thorntail.application.api.commands;

import org.apache.commons.lang3.Validate;
import org.jeecqrs.common.commands.AbstractCommand;
import org.jeecqrs.example.thorntail.domain.model.order.OrderId;

import java.util.Collections;
import java.util.Map;

public final class PlaceOrderCommand extends AbstractCommand<PlaceOrderCommand> {

    private final OrderId orderId;
    private final String ordererName;
    private final Map<String, Integer> orderedProducts;

    public PlaceOrderCommand(OrderId orderId, String ordererName, Map<String, Integer> orderedProducts) {
        Validate.notNull(orderId);
        Validate.notNull(ordererName);
        Validate.notNull(orderedProducts);
        this.orderId = orderId;
        this.ordererName = ordererName;
        this.orderedProducts = orderedProducts;
    }

    public OrderId orderId() {
        return orderId;
    }

    public String ordererName() {
        return ordererName;
    }

    public Map<String, Integer> orderedProducts() {
        return Collections.unmodifiableMap(orderedProducts);
    }
    
}
