package org.jeecqrs.example.openejb.internal;

import javax.inject.Inject;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeecqrs.example.openejb.domain.model.billing.Invoice;
import org.jeecqrs.example.openejb.domain.model.billing.InvoiceRepository;
import org.jeecqrs.example.openejb.domain.model.billing.IssueInvoiceService;
import org.jeecqrs.example.openejb.domain.model.order.OrderRepository;

public class CreateInvoiceForOrderCommandHandler extends AbstractCommandHandler<CreateInvoiceForOrderCommand> {

    @Inject
    private InvoiceRepository invoiceRepository;

    @Inject
    private OrderRepository orderRepository;

    @Override
    public void handle(CreateInvoiceForOrderCommand command) {
        IssueInvoiceService iis = new IssueInvoiceService(orderRepository);
        Invoice invoice = iis.issueInvoiceForOrder(command.orderId());
        invoiceRepository.save(invoice, command.id());
    }

}
