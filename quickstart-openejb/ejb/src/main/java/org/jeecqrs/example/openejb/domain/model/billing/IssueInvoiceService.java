package org.jeecqrs.example.openejb.domain.model.billing;

import java.math.BigDecimal;
import org.jeecqrs.example.openejb.domain.model.order.Order;
import org.jeecqrs.example.openejb.domain.model.order.OrderId;
import org.jeecqrs.example.openejb.domain.model.order.OrderRepository;
import org.joda.time.LocalDate;

public class IssueInvoiceService {

    private final OrderRepository orderRepository;

    public IssueInvoiceService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Invoice issueInvoiceForOrder(OrderId orderId) {
        Order order = orderRepository.ofIdentity(orderId);
        InvoiceId invoiceId = InvoiceId.fromString(orderId.toString());
        String text = "Invoice for order #" + order.id();
        BigDecimal totals = order.orderTotals();
        return new Invoice(invoiceId, new LocalDate(), order.id(),
                order.orderer().name(), text, totals);
    }

}
