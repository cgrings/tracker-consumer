package io.cgrings.consumer.processor;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.cgrings.consumer.service.ContactService;
import io.cgrings.tracker.model.ContactInput;

@Component
public class ContactMessageProcessor {

    @Autowired
    private ContactService contactService;

    @RabbitListener(queuesToDeclare =  @Queue(name = "contact-queue"))
    public void processMessage(final ContactInput contactInput) {
        this.contactService.convertAndSave(contactInput);
    }

}
