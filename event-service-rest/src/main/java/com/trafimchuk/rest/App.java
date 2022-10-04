package com.trafimchuk.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.trafimchuk.dto")
@ComponentScan({"com.trafimchuk.impl", "com.trafimchuk.rest"})
@EnableJpaRepositories("com.trafimchuk.impl")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
