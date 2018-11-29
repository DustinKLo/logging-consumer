package com.example.loggingconsumer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import java.util.concurrent.CountDownLatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

import com.example.loggingconsumer.Tweets;
import com.example.loggingconsumer.TweetRepository;

import com.example.loggingconsumer.TwitterObject;
import com.example.loggingconsumer.TwitterPayload;
import com.example.loggingconsumer.TwitterObject;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Receiver {

    // private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);
    public CountDownLatch getLatch() {
        return latch;
    }

    @Autowired
    private TweetRepository tweetRepository;

    @KafkaListener(topics = "test-twitter-topic")
    public void receive(String payload) {
        // LOGGER.info("received payload='{}'", payload);

        Gson gson = new Gson();
        TwitterObject twitterObject = gson.fromJson(payload, TwitterObject.class);
        TwitterPayload twitterPayload = twitterObject.getTwitterPayload();
        TwitterUser twitterUser = twitterPayload.getTwitterUser();

        Tweets tweet = new Tweets();
        tweet.setText(twitterPayload.getText());
        tweet.setUsername(twitterUser.getName());
        tweet.setScreenName(twitterUser.getScreenName());
        tweet.setIsVerified(twitterUser.getVerified());
        tweet.setCreatedAt(twitterPayload.getCreatedAt());
        tweet.setLang(twitterPayload.getLang());
        tweet.setIsRetweet(twitterPayload.getRetweet());

        tweetRepository.save(tweet);

        String timestamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date());
        System.out.println("Kafka object retrieved and uploaded to database: " + timestamp);

        latch.countDown();
    }

}
