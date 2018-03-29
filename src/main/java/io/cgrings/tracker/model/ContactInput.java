package io.cgrings.tracker.model;

public class ContactInput {

    private String sid;
    private String uid;
    private String name;
    private String email;

    public String getSid() {
        return sid;
    }

    public void setSid(final String sid) {
        this.sid = sid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

}
