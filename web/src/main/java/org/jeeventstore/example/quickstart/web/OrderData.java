package org.jeeventstore.example.quickstart.web;

import java.io.Serializable;
import java.util.List;

public class OrderData implements Serializable {

    private String orderer;
    private final List<OrderDataModel> list;

    public OrderData(String orderer, List<OrderDataModel> list) {
        this.orderer = orderer;
        this.list = list;
    }

    public String getOrderer() {
        return orderer;
    }

    public void setOrderer(String orderer) {
        this.orderer = orderer;
    }

    public List<OrderDataModel> getList() {
        return list;
    }
    
}
