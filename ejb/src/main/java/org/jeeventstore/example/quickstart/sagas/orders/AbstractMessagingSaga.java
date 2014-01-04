package org.jeeventstore.example.quickstart.sagas.orders;

import org.jeecqrs.bundle.jcommondomain.sagas.AbstractSaga;
import org.jeecqrs.common.Identity;
import org.jeeventstore.example.quickstart.application.internal.customers.NotifyCustomerCommand;
import org.jeeventstore.example.quickstart.domain.model.order.OrderId;
import org.jeeventstore.example.quickstart.domain.model.order.OrderPlaced;

/**
 *
 * - Order received
 * - invoice -> paid
 * - dann shipping
 * 
 * CustomerOrderPaid
 * 
 */
public class OrderTrackingSaga extends AbstractSaga {

    private OrderId orderId = null;
    private String orderer = null;
    private boolean completed = false;
    private boolean canceled = false;

    @Override
    public Identity id() {
        return this.orderId;
    }

    protected void when(OrderPlaced event) {
        System.out.println("Received order placed event: " + event.orderer());
        this.orderId = event.orderId();
        this.orderer = event.orderer().name();
        this.sendCustomerMessage("Thank you for your order!");
    }

    private void sendCustomerMessage(String msg) {
        NotifyCustomerCommand cmd = new NotifyCustomerCommand(orderer, msg);
        this.executeCommand(cmd);
    }

    @Override
    public boolean isCompleted() {
        return this.completed;
    }
    
}
