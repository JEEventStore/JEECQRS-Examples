package org.jeecqrs.example.openejb.application.impl.queries;

import java.util.HashMap;
import java.util.Map;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import org.jeecqrs.example.openejb.application.api.queries.OrderBean;

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
