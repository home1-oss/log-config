package cn.home1.logging.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by: Song Feng
 * Created time: 2018/7/4
 * Description:
 */
@Slf4j
@SpringBootApplication
public class LogbackApplication {

    public static void main(String[] args){
        SpringApplication.run(LogbackApplication.class, args);

        // print logback's internal status
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }

    @Bean
    public CommandLineRunner init() {

        return new CommandLineRunner() {
            @Override
            public void run(final String... strings) throws Exception {
                log.error("Hello World!");
            }
        };

    }
}
