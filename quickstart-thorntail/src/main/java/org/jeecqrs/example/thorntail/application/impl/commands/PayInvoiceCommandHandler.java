package org.jeecqrs.example.thorntail.application.impl.commands;

import org.jeecqrs.example.thorntail.application.api.commands.PayInvoiceCommand;
import org.jeecqrs.example.thorntail.domain.model.billing.InvoiceId;
import org.jeecqrs.example.thorntail.domain.model.billing.Payment;
import org.jeecqrs.example.thorntail.domain.model.billing.PaymentId;
import org.jeecqrs.example.thorntail.domain.model.billing.PaymentRepository;
import org.jeecqrs.integration.jcommondomain.commands.AbstractCommandHandler;
import org.joda.time.DateTime;

import javax.inject.Inject;

public class PayInvoiceCommandHandler extends AbstractCommandHandler<PayInvoiceCommand> {

    @Inject
    private PaymentRepository paymentRepository;

    @Override
    public void handle(PayInvoiceCommand command) {
        InvoiceId invoiceId = command.invoiceId();
        Payment payment = new Payment(new PaymentId(), invoiceId, new DateTime());
        paymentRepository.add(payment, command.id());
    }

}
