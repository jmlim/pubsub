package io.jmlim.tutorial.redis.pubsub.redis;

public interface MessagePublisher {

    void publish(final String message);
}