package org.jeecqrs.example.quickstart.internal;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeecqrs.example.quickstart.domain.model.billing.Invoice;
import org.jeecqrs.example.quickstart.domain.model.billing.InvoiceRepository;
import org.jeecqrs.example.quickstart.domain.model.billing.IssueInvoiceService;
import org.jeecqrs.example.quickstart.domain.model.order.OrderRepository;

@Stateless
public class CreateInvoiceForOrderCommandHandler extends AbstractCommandHandler<CreateInvoiceForOrderCommand> {

    @EJB
    private InvoiceRepository invoiceRepository;

    @EJB
    private OrderRepository orderRepository;

    @Override
    public void handle(CreateInvoiceForOrderCommand command) {
        IssueInvoiceService iis = new IssueInvoiceService(orderRepository);
        Invoice invoice = iis.issueInvoiceForOrder(command.orderId());
        invoiceRepository.save(invoice, command.id());
    }

}
