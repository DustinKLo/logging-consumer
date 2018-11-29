package com.example.loggingconsumer;

import org.springframework.data.repository.CrudRepository;

import com.example.loggingconsumer.Tweets;

public interface TweetRepository extends CrudRepository<Tweets, Integer> {

}