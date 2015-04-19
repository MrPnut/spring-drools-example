package com.ncsoftworks.sandbox.springdrools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Nick on 4/18/2015.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.ncsoftworks.sandbox.springdrools.config", "com.ncsoftworks.sandbox.springdrools.controller" })
public class App {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
