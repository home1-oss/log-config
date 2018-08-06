package cn.home1.logging.log4j2;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * see: https://codingcraftsman.wordpress.com/2015/04/28/log4j2-mocking-with-mockito-and-junit/
 * see: https://stackoverrun.com/cn/q/200653
 */
@ActiveProfiles({"default"})
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
    "debug=false", // debug=false can not disable AUTO-CONFIGURATION REPORT
    "logging.level.root=INFO"
})
@Import(LoggingTestApplication.class)
@Slf4j
public class SpringBootLog4j2LoggingLevelTest {

  @Autowired
  private LoggingTestApplication application;

  @Test
  public void testLevel() {
    this.application.infoLog("hello, {}", "world");
    // TODO fix this
    //assertTrue(this.out.toString().contains("hello, world"));

    this.application.debugLog("hello, {}", "debug log");
    // TODO fix this
    //assertFalse(this.out.toString().contains("hello, debug log"));
  }
}
