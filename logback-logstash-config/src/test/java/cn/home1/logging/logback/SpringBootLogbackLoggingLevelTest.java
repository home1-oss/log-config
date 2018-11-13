package cn.home1.logging.logback;

import lombok.extern.slf4j.Slf4j;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


/**
 * see: https://jsoftbiz.wordpress.com/2011/11/29/unit-testing-asserting-that-a-line-was-logged-by-logback/
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LogbackApplication.class)
@Slf4j
public class SpringBootLogbackLoggingLevelTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    LogService logService;

    @Autowired
    Environment environment;

    @Test
    public void testLevel() {
        final String tmpdir = System.getProperty("java.io.tmpdir");
        log.info("java.io.tmpdir: {}", tmpdir);

        final String logFile = tmpdir + "tests.log";
        log.info("logFile: {}", logFile);

        logService.doLog(null, Level.INFO, "test info");
        assertFalse(this.systemOutRule.getLog().contains("test info"));

        logService.doLog("org.springframework.test.context.support", Level.INFO, "hello, world");
        assertTrue(this.systemOutRule.getLog().contains("hello, world"));

        logService.doLog("org.springframework.test.context.support", Level.DEBUG, "hello, debug world");
        assertFalse(this.systemOutRule.getLog().contains("hello, debug log"));

        logService.doLog("org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor", Level.INFO, "test info");
        assertFalse(this.systemOutRule.getLog().contains("test info"));

        logService.doLog("org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor", Level.WARN, "test warn");
        assertTrue(this.systemOutRule.getLog().contains("test warn"));
    }

    @Test
    public void testReadSpringProperty() {
        String applicationName = environment.getProperty("spring.application.name");
        assertEquals(applicationName, logService.getLogProperty("application"));

        //String instanceId = environment.getProperty("eureka.instance.instance-id");
    }
}
