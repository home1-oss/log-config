package cn.home1.logging.logback;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles({"default"})
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
    "debug=false", // debug=false can not disable AUTO-CONFIGURATION REPORT
    "logging.level.root=INFO"
})
@Import(LoggingTestApplication.class)
@Slf4j
public class SpringBootLogbackLoggingLevelTest {

  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Autowired
  private LoggingTestApplication application;

  @Test
  public void testLevel() {
    final String tmpdir = System.getProperty("java.io.tmpdir");
    log.info("java.io.tmpdir: {}", tmpdir);

    final String logFile = tmpdir + "tests.log";
    log.info("logFile: {}", logFile);

    this.application.infoLog("hello, {}", "world");
    assertTrue(this.systemOutRule.getLog().contains("hello, world"));

    this.application.debugLog("hello, {}", "debug log");
    assertFalse(this.systemOutRule.getLog().contains("hello, debug log"));
  }
}
