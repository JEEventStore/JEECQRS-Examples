package org.jeecqrs.example.thorntail.internal;

import org.jeecqrs.example.thorntail.domain.model.billing.Invoice;
import org.jeecqrs.example.thorntail.domain.model.billing.InvoiceRepository;
import org.jeecqrs.example.thorntail.domain.model.billing.IssueInvoiceService;
import org.jeecqrs.example.thorntail.domain.model.order.OrderRepository;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;

import javax.inject.Inject;

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
