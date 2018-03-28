package io.cgrings.consumer.processor;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.cgrings.consumer.service.PageViewService;
import io.cgrings.tracker.model.PageViewInput;

@Component
public class PageViewMessageProcessor {

    @Autowired
    private PageViewService pageViewService;

    @RabbitListener(queuesToDeclare =  @Queue(name = "pageview-queue"))
    public void processMessage(final PageViewInput pageViewInput) {
        this.pageViewService.convertAndSave(pageViewInput);
    }

}
