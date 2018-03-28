package io.cgrings.tracker.model;

import java.time.ZonedDateTime;

public class PageViewInput {

    private String id;
    private String url;
    private ZonedDateTime dtz;

    public PageViewInput(final String id, final String url, final ZonedDateTime dtz) {
        this.id = id;
        this.url = url;
        this.dtz = dtz;
    }

    public PageViewInput() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ZonedDateTime getDtz() {
        return dtz;
    }

    public void setDtz(ZonedDateTime dtz) {
        this.dtz = dtz;
    }

}
