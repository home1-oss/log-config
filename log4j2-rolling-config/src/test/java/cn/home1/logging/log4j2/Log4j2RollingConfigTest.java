package cn.home1.logging.log4j2;

import cn.home1.logging.log4j2.Log4j2TestApplication.ApplicationController;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@SpringBootTest(classes = Log4j2TestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Log4j2RollingConfigTest {

  @Autowired
  private ApplicationController controller;

  @Test
  public void testLog4j2RollingConfig() {
    this.controller.writeLog("test");
  }
}
