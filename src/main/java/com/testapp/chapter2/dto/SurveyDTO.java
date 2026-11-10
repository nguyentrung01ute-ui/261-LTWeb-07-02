package com.testapp.chapter2.dto;

import java.io.Serializable;

public class SurveyDTO implements Serializable {
    private String heardFrom;
    private String wantsUpdates;
    private String emailOK;
    private String contactVia;

    public SurveyDTO() {
        this.heardFrom = "";
        this.wantsUpdates = "";
        this.emailOK = "";
        this.contactVia = "";
    }

    public SurveyDTO(String heardFrom, String wantsUpdates, String emailOK, String contactVia) {
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
