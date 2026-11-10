package com.testapp.chapter2.model;

import java.io.Serializable;

public class Survey implements Serializable {
    private String heardFrom;
    private String wantsUpdates;
    private String emailOK;
    private String contactVia;

    public Survey() {
        this.heardFrom = "";
        this.wantsUpdates = "";
        this.emailOK = "";
        this.contactVia = "";
    }

    public Survey(String heardFrom, String wantsUpdates, String emailOK, String contactVia) {
        this.heardFrom = heardFrom;
        this.wantsUpdates = wantsUpdates;
        this.emailOK = emailOK;
        this.contactVia = contactVia;
    }

    public String getHeardFrom() {
        return heardFrom;
    }

    public void setHeardFrom(String heardFrom) {
        this.heardFrom = heardFrom;
    }

    public String getWantsUpdates() {
        return wantsUpdates;
    }

    public void setWantsUpdates(String wantsUpdates) {
        this.wantsUpdates = wantsUpdates;
    }

    public String getEmailOK() {
        return emailOK;
    }

    public void setEmailOK(String emailOK) {
        this.emailOK = emailOK;
    }

    public String getContactVia() {
        return contactVia;
    }

    public void setContactVia(String contactVia) {
        this.contactVia = contactVia;
    }
}
