package io.cgrings.consumer.service;

import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.cgrings.consumer.model.PageView;
import io.cgrings.consumer.repository.PageViewRepository;
import io.cgrings.tracker.model.PageViewInput;

@Service
public class PageViewServiceImpl implements PageViewService {

	private Logger logger = LoggerFactory.getLogger(PageViewService.class);

	@Autowired
	private PageViewRepository pageViewRepository;

    @Override
    @Transactional
    public PageView save(final PageView pageView) {
        final PageView result = this.pageViewRepository.save(pageView);
        logger.info("Page View with id '{}' saved!", result.getId());
        return result;
    }

    @Override
    public PageView convertAndSave(final PageViewInput pageViewInput) {
        final PageView pageView = new PageView();
        pageView.setUrl(pageViewInput.getUrl());
        pageView.setTracker(pageViewInput.getId());
        pageView.setDateTime(pageViewInput.getDtz().withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
        return this.save(pageView);
    }

}
