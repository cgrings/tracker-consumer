package io.cgrings.consumer.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "pageviews")
public class PageView {

    @Id
    private String id;
    private String url;
    private String tracker;
    private LocalDateTime dateTime;
    @Version
    @Field("__v")
    private Integer version;

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

    public String getTracker() {
        return tracker;
    }

    public void setTracker(String tracker) {
        this.tracker = tracker;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}