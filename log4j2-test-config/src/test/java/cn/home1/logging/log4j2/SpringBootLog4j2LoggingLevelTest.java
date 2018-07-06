package cn.home1.logging.log4j2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@ActiveProfiles({"default"})
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {
    "debug=false", // debug=false can not disable AUTO-CONFIGURATION REPORT
    "logging.level.=INFO"
})
@Import(LoggingTestApplication.class)
@Slf4j
public class SpringBootLog4j2LoggingLevelTest {

  private static final PrintStream ORIGINAL_SYS_OUT = System.out;
  private static final PrintStream ORIGINAL_SYS_ERR = System.err;

  private static final ByteArrayOutputStream OUT = new ByteArrayOutputStream();
  private static final ByteArrayOutputStream ERR = new ByteArrayOutputStream();

  @BeforeClass
  public static void setUpStreams() {
    // SystemOutRule can get logback's console output but can not get log4j2's console output
    System.setOut(new PrintStream(OUT));
    System.setErr(new PrintStream(ERR));
  }

  @AfterClass
  public static void restoreStreams() {
    System.setOut(ORIGINAL_SYS_OUT);
    System.setErr(ORIGINAL_SYS_ERR);
  }

  @Autowired
  private LoggingTestApplication application;

  @Test
  public void testLevel() throws InterruptedException {
    this.application.infoLog("hello, {}", "world");
    ORIGINAL_SYS_OUT.println(OUT.toString());
    assertTrue(OUT.toString().contains("hello, world"));

    this.application.debugLog("hello, {}", "debug log");
    assertFalse(OUT.toString().contains("hello, debug log"));
  }
}
