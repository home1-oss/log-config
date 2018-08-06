package cn.home1.logging.log4j2;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.slf4j.LoggerFactory;

@Slf4j
public class Log4j2TestConfigTest {

  @Test
  public void testLog4j2TestConfig() {
    log.trace("you should not see this line");
    log.debug("you should see this line");
    log.info("you should see this line");

    LoggerFactory.getLogger("org.testcontainers").debug("you should not see this line");
    LoggerFactory.getLogger("org.testcontainers").info("you should see this line");

    LoggerFactory.getLogger("org.apache.http").warn("you should see this line");
    LoggerFactory.getLogger("org.apache.http").info("you should not see this line");
  }
}
