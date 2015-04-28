package com.ncsoftworks.sandbox.springdrools.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

/**
 * Created by Nick on 4/18/2015.
 */
@Profile("xml")
@Configuration
@ImportResource("config/droolsContext.xml")
public class DroolsXmlNamespaceConfig {
}
