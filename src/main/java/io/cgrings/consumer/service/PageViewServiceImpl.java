package io.cgrings.consumer.service;

import java.time.ZoneId;
import java.util.stream.Stream;

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
        pageView.setSession(pageViewInput.getSid());
        pageView.setDateTime(pageViewInput.getDtz().withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());
        pageView.setUser(pageViewInput.getUid());
        return this.save(pageView);
    }

    @Override
    // TODO: move to a daily brackgroud task
    public void updateUserBySession(final String user, final String session) {
        final Stream<PageView> sameSessionPageViews = this.pageViewRepository.findBySessionAndUserExists(session, Boolean.FALSE);
        sameSessionPageViews.forEach(sameSession -> {
            sameSession.setUser(user);
            this.save(sameSession);
        });
    }

}
