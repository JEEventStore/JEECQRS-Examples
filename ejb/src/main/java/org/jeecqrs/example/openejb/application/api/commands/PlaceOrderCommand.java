package org.jeecqrs.example.openejb.application.api.commands;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jeecqrs.common.commands.AbstractCommand;

public final class PlaceOrderCommand extends AbstractCommand<PlaceOrderCommand> {

    private final String ordererName;
    private final Map<String, Integer> orderedProducts;

    public PlaceOrderCommand(String ordererName, Map<String, Integer> orderedProducts) {
        this.ordererName = ordererName;
        this.orderedProducts = new HashMap<>(orderedProducts);
    }

    public String ordererName() {
        return ordererName;
    }

    public Map<String, Integer> orderedProducts() {
        return Collections.unmodifiableMap(orderedProducts);
    }
    
}
