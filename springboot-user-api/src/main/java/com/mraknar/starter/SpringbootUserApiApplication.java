package com.mraknar.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.mraknar")
@EntityScan(basePackages = "com.mraknar")
@EnableJpaRepositories(basePackages = "com.mraknar")
public class SpringbootUserApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootUserApiApplication.class, args);
    }

}
