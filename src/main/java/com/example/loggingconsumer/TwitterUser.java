package com.example.loggingconsumer;

import com.google.gson.annotations.SerializedName;


public class TwitterUser {
    String name;

    @SerializedName("screen_name")
    String screenName;

    boolean verified;

    TwitterUser() {
        this.verified = false;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }
    public String getScreenName() {
        return this.screenName;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean getVerified() {
        return this.verified;
    }
}
