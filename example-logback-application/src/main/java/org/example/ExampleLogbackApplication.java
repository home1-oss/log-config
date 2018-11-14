package org.example;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class ExampleLogbackApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ExampleLogbackApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {

        return new CommandLineRunner() {
            @Override
            public void run(final String... strings) throws Exception {
                log.info("Hello World!");
            }
        };

    }
}
