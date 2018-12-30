package org.jeecqrs.example.thorntail.application.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRequestBean {

    private List<OrderLineBean> orders;

    private String customerName;

    public List<OrderLineBean> getOrders() {
        return orders;
    }

    public Map<String, Integer> ordersAsMap() {
        Map<String, Integer> res = new HashMap<>();
        for (OrderLineBean b: orders)
            res.put(b.productId, b.amount);
        return res;
    }

    public void setOrders(List<OrderLineBean> orders) {
        this.orders = orders;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public static class OrderLineBean {
        public String productId;
        public Integer amount;
    }
    
}
