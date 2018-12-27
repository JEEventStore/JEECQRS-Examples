package org.jeecqrs.example.openejb.application.api.queries;

import java.io.Serializable;
import java.util.Date;

public final class OrderBean implements Serializable {

    public static enum Status {
        NEW,
        SHIPPED,
        CANCELLED,
    }

    private final String orderId;
    private final Date orderDate;
    private final String customerName;
    private Status status;

    public OrderBean(String orderId, Date orderDate, String customerName) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.status = Status.NEW;
    }

    public void ship() {
        this.status = Status.SHIPPED;
    }

    public void cancel() {
        this.status = Status.CANCELLED;
    }

    public String getOrderId() {
        return orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Status getStatus() {
        return status;
    }

}
