package com.example.loggingconsumer;

import com.example.loggingconsumer.TwitterPayload;
import com.google.gson.annotations.SerializedName;

public class TwitterObject {

    @SerializedName("payload")
    TwitterPayload twitterPayload;

    public void setTwitterPayload(TwitterPayload twitterPayload) {
        this.twitterPayload = twitterPayload;
    }

    public TwitterPayload getTwitterPayload() {
        return twitterPayload;
    }
}
