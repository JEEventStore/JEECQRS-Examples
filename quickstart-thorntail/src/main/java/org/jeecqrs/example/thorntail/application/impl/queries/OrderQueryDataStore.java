package org.jeecqrs.example.thorntail.application.impl.queries;

import org.jeecqrs.example.thorntail.application.api.queries.OrderBean;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple in-memory data store for orders.
 */
@Singleton
public class OrderQueryDataStore {
    
    private final Map<String, OrderBean> entries = new HashMap<>();

    @Lock(LockType.WRITE)
    public void put(OrderBean entry) {
        entries.put(entry.getOrderId(), entry);
    }

    @Lock(LockType.READ)
    public OrderBean get(String orderId) {
        return entries.get(orderId);
    }
    
}
