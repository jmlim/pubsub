package io.jmlim.tutorial.redis.pubsub.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RedisConfig.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class RedisMessageListenerIntegrationTest {

    //   private static redis.embedded.RedisServer redisServer;

    @Autowired
    private RedisMessagePublisher redisMessagePublisher;

    /*  @BeforeClass
      public static void startRedisServer() throws IOException {
          redisServer = new redis.embedded.RedisServer(6380);
          redisServer.start();
      }

      @AfterClass
      public static void stopRedisServer() throws IOException {
          redisServer.stop();
      }
  */
    @Test
    public void testOnMessage() throws Exception {
        String message = "Message " + UUID.randomUUID();
        redisMessagePublisher.publish(message);
        Thread.sleep(100);
        assertTrue(RedisMessageSubscriber.messageList.get(0).contains(message));
    }
}