package io.cgrings.tracker.model;

import java.time.ZonedDateTime;

public class PageViewInput {

    private String sid;
    private String url;
    private ZonedDateTime dtz;
    private String uid;

    public PageViewInput(final String sid, final String url, final ZonedDateTime dtz) {
        this.sid = sid;
        this.url = url;
        this.dtz = dtz;
    }

    public PageViewInput() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

}
