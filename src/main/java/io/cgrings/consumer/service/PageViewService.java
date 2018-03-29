package io.cgrings.consumer.service;

import io.cgrings.consumer.model.PageView;
import io.cgrings.tracker.model.PageViewInput;

public interface PageViewService {

    PageView convertAndSave(final PageViewInput pageViewInput);

    PageView save(final PageView pageView);

    void updateUserBySession(final String user, final String session);

}
