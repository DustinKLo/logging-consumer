package com.example.loggingconsumer;

import com.example.loggingconsumer.TwitterUser;
import com.google.gson.annotations.SerializedName;
import org.springframework.context.annotation.Bean;

import java.util.Date;


public class TwitterPayload {
    @SerializedName("user")
    TwitterUser twitterUser;

    String text;

    @SerializedName("created_at")
    Date createdAt;

    @SerializedName("is_retweet")
    boolean isRetweet;

    String lang;


    public void setTwitterUser(TwitterUser twitterUser) {
        this.twitterUser = twitterUser;
    }
    public TwitterUser getTwitterUser() {
        return this.twitterUser;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return this.text;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setRetweet(boolean retweet) {
        this.isRetweet = retweet;
    }
    public boolean getRetweet() {
        return this.isRetweet;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
    public String getLang() {
        return this.lang;
    }
}
