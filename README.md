Java spring application

consumes data from a kafka topic source from twitter and pushes it to PostgreSQL


download kafka: https://kafka.apache.org/downloads

quickstart to get kafka running: https://kafka.apache.org/quickstart


kafka twitter source connector: https://github.com/Eneco/kafka-connect-twitter

copy the files to your kafka connect directory


once you have kafka running with kafka connect

```
curl -X POST localhost:8083/connectors
{
    "name": "test-twitter-source",
    "config": {
	    "connector.class": "com.eneco.trading.kafka.connect.twitter.TwitterSourceConnector",
	    "tasks.max": 1,
	    "topic": "test-twitter-topic",
	    "topics": "test-twitter-topic",
	    "twitter.consumerkey": "",
	    "twitter.consumersecret": "",
	    "twitter.token": "",
	    "twitter.secret": "",
	    "track.terms": "programming,java,kafka,scala"
	}
}
```



postgresql commands:

```
createdb springbootdb

CREATE TABLE tweets (
    id integer NOT NULL,
    created_at timestamp with time zone NOT NULL,
    is_retweet boolean NOT NULL,
    lang character varying(255),
    screen_name character varying(255),
    text text,
    username character varying(255),
    verified boolean NOT NULL
);
```

to run application:
```
mvn clean package
java -jar target/logging-consumer-0.0.1-SNAPSHOT.jar
```