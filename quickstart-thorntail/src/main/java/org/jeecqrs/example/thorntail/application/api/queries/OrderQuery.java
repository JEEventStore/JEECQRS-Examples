package org.jeecqrs.example.thorntail.application.api.queries;

public interface OrderQuery {
    
    OrderBean getOrder(String orderId);
    
}
