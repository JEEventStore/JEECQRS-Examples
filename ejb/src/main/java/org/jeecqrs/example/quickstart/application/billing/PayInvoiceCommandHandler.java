package org.jeecqrs.example.quickstart.application.billing;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.command.registry.autodiscover.AutoDiscoveredCommandHandler;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeecqrs.example.quickstart.domain.model.billing.InvoiceId;
import org.jeecqrs.example.quickstart.domain.model.billing.Payment;
import org.jeecqrs.example.quickstart.domain.model.billing.PaymentId;
import org.jeecqrs.example.quickstart.domain.model.billing.PaymentRepository;
import org.joda.time.DateTime;

@Stateless
public class PayInvoiceCommandHandler extends AbstractCommandHandler<PayInvoiceCommand> 
implements AutoDiscoveredCommandHandler<PayInvoiceCommand>
{

    @EJB
    private PaymentRepository paymentRepository;

    @Override
    public void handle(PayInvoiceCommand command) {
        InvoiceId invoiceId = InvoiceId.fromString(command.invoiceId());
        Payment payment = new Payment(new PaymentId(), invoiceId, DateTime.now());
        paymentRepository.add(payment, command.id());
    }

}
