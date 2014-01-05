package org.jeeventstore.example.quickstart.sagas.customersimulator;

import java.util.logging.Logger;
import org.jeecqrs.integration.jcommondomain.sagas.AbstractSingleEventSaga;
import org.jeeventstore.example.quickstart.application.billing.PayInvoiceCommand;
import org.jeeventstore.example.quickstart.domain.model.billing.InvoiceIssued;

public class CustomerSimulator extends AbstractSingleEventSaga<CustomerSimulator, InvoiceIssued> {

    private static final Logger log = Logger.getLogger(CustomerSimulator.class.getSimpleName());

    @Override
    protected void when(InvoiceIssued event) {
        if (eventSourceReplayActive())
            return;
        if (Math.random() < 0.5) {
            log.info("Customer decided to pay the invoice.");
            this.executeCommand(new PayInvoiceCommand(event.invoiceId().toString()));
        } else {
                log.info("Customer decided to ignore the invoice.");
        }
    }
    
}
