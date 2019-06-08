package io.jmlim.tutorial.redis.pubsub.controller;

import io.jmlim.tutorial.redis.pubsub.redis.RedisMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RedisController {

    @Autowired
    private RedisMessagePublisher publisher;

    @GetMapping(value = "/redis-pub")
    public Map<String, String> index() {

        publisher.publish("임정묵 천재 트루");
        Map<String, String> returnParams = new HashMap<>();
        returnParams.put("success", "success");
        return returnParams;
    }
}
