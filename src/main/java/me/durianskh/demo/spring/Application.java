package me.durianskh.demo.spring;

import me.durianskh.demo.spring.annotation.HelloScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * spring boot application from maven-archetype by durianskh@gmail.com
 */
@HelloScan(basePackage = "me.durianskh.demo.spring.service")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
