package cn.home1.logging.logback;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LoggingTestApplication {

  public void debugLog(final String msg, final Object... arguments) {
    log.debug(msg, arguments);
  }

  public void infoLog(final String msg, final Object... arguments) {
    log.info(msg, arguments);
  }

  public static void main(final String... args) {
    SpringApplication.run(LoggingTestApplication.class, args);
  }
}
