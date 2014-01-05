package org.jeecqrs.example.quickstart.application.billing;

import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeecqrs.example.quickstart.domain.model.billing.InvoiceId;
import org.jeecqrs.example.quickstart.domain.model.billing.Payment;
import org.jeecqrs.example.quickstart.domain.model.billing.PaymentId;
import org.jeecqrs.example.quickstart.domain.model.billing.PaymentRepository;

@Stateless
public class PayInvoiceCommandHandler extends AbstractCommandHandler<PayInvoiceCommand> {

    @EJB
    private PaymentRepository paymentRepository;

    @Override
    public void handleCommand(PayInvoiceCommand command) {
        InvoiceId invoiceId = InvoiceId.fromString(command.invoiceId());
        Payment payment = new Payment(new PaymentId(), invoiceId, new Date());
        paymentRepository.add(payment, command.id());
    }

}
