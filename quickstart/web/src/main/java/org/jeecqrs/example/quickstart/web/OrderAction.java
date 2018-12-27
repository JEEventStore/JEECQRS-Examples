package org.jeecqrs.example.quickstart.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.jeecqrs.common.commands.CommandBus;
import org.jeecqrs.example.quickstart.application.order.PlaceOrderCommand;
import org.jeecqrs.example.quickstart.application.product.ProductList;
import org.jeecqrs.example.quickstart.application.product.ProductListEntry;

@RequestScoped
@Named
public class OrderAction implements Serializable {
    
    @EJB
    private ProductList productList;

    @EJB
    private CommandBus commandBus;

    @Inject
    private FacesContext facesContext;

    private OrderData data;

    @PostConstruct
    public void init() {
        Collection<ProductListEntry> products = productList.allProducts();
        List<OrderDataModel> odm = new ArrayList<>();
        for (ProductListEntry p : products)
            odm.add(new OrderDataModel(p));
        data = new OrderData("My name", odm);
    }

    public OrderData getData() {
        return data;
    }

    public String placeOrder() {

        Map<String, Integer> orders = new HashMap<>();
        boolean selected = false;
        for (OrderDataModel odm : data.getList()) {
            if (odm.getSelected() != null && odm.getSelected()) {
                selected = true;
                orders.put(odm.getProduct().getProductId(), 1);
            }
        }

        if (!selected) {
            facesContext.addMessage(null, new FacesMessage("Please select a product to order."));
            return null;
        }
        
        PlaceOrderCommand cmd = new PlaceOrderCommand(data.getOrderer(), orders);
        commandBus.send(cmd);
        facesContext.addMessage(null, new FacesMessage("Thank you, your order has been placed."));
        init();
        return null;
    }

    public boolean hasProducts() {
        return !productList.allProducts().isEmpty();
    }

}
