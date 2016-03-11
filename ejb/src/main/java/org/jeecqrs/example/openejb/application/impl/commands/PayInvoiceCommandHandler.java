package org.jeecqrs.example.openejb.application.impl.commands;

import org.jeecqrs.example.openejb.application.api.commands.PayInvoiceCommand;
import javax.inject.Inject;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.jeecqrs.example.openejb.domain.model.billing.InvoiceId;
import org.jeecqrs.example.openejb.domain.model.billing.Payment;
import org.jeecqrs.example.openejb.domain.model.billing.PaymentId;
import org.jeecqrs.example.openejb.domain.model.billing.PaymentRepository;
import org.joda.time.DateTime;

public class PayInvoiceCommandHandler extends AbstractCommandHandler<PayInvoiceCommand> {

    @Inject
    private PaymentRepository paymentRepository;

    @Override
    public void handle(PayInvoiceCommand command) {
        InvoiceId invoiceId = InvoiceId.fromString(command.invoiceId());
        Payment payment = new Payment(new PaymentId(), invoiceId, new DateTime());
        paymentRepository.add(payment, command.id());
    }

}
