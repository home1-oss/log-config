package cn.home1.logging.log4j2;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
public class Log4j2TestApplication {

  @Controller
  @Slf4j
  public static class ApplicationController {

    @RequestMapping(name = "log", method = POST)
    public void writeLog(@RequestParam(name = "content") final String content) {
      log.info("writeLog content: {}", content);
    }
  }

  public static void main(final String... args) {
    SpringApplication.run(Log4j2TestApplication.class, args);
  }
}
