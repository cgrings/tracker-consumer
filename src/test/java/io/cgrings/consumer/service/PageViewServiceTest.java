package io.cgrings.consumer.service;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.cgrings.consumer.Application;
import io.cgrings.consumer.model.PageView;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(profiles = "test")
public class PageViewServiceTest {

    @Autowired
    private PageViewService pageViewService;

    @Test
    public void saveTest() {
        final PageView pageHit = new PageView();
        pageHit.setUrl("bar.html");
        pageHit.setTracker("foo");
        pageHit.setDateTime(LocalDateTime.now());
        final PageView pageHitResult = this.pageViewService.save(pageHit);
        Assert.assertNotNull(pageHitResult.getId());
    }
}
