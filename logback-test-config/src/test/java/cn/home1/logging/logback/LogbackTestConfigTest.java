package cn.home1.logging.logback;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.slf4j.LoggerFactory;

@Slf4j
public class LogbackTestConfigTest {

  @Test
  public void testLogbackTestConfig() {
    log.trace("you should not see this line");
    log.debug("you should see this line");
    log.info("you should see this line");

    LoggerFactory.getLogger("org.testcontainers").debug("you should not see this line");
    LoggerFactory.getLogger("org.testcontainers").info("you should see this line");

    LoggerFactory.getLogger("org.apache.http").warn("you should see this line");
    LoggerFactory.getLogger("org.apache.http").info("you should not see this line");
  }
}
