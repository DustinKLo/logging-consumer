package com.example.loggingconsumer;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
public class Tweets {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String username;
    private String screenName;
    private boolean verified;

    @Column(columnDefinition = "text")
    private String text;

    private String lang;
    private boolean isRetweet;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE", nullable = false)
    private Date createdAt;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setIsVerified(boolean verified) {
        this.verified = verified;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return this.text;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    public void setIsRetweet(boolean isRetweet) {
        this.isRetweet = isRetweet;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
