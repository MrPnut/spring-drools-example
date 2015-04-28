package com.ncsoftworks.sandbox.springdrools.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Nick on 4/18/2015.
 */
@Profile("javaconfig")
@Configuration
@ComponentScan(basePackages = { "org.kie.spring.annotations" })
public class DroolsJavaConfig {}
