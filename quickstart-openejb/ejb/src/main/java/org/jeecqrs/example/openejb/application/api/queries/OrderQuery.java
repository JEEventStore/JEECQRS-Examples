package org.jeecqrs.example.openejb.application.api.queries;

public interface OrderQuery {
    
    OrderBean getOrder(String orderId);
    
}
