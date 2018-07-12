package logback.example;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import logback.example.service.LogService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogbackApplication.class)
@Slf4j
public class LogGenerator {

  static {
    System.setProperty("spring.profiles.active", "log_config_test");
    System.setProperty("logging.logstash.destination", "127.0.0.1:51401");
  }

  @Autowired
  LogService logService;

  //@Test
  public void generateLogs() {
    final Marker logstashTag = MarkerFactory.getMarker("standard_log");

    while (!Thread.currentThread().isInterrupted()) {
      try {

        this.logService.doLog("generator", logstashTag, Level.WARN, "generated log");

        Thread.sleep(TimeUnit.SECONDS.toMillis(3L));
      } catch (final InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
