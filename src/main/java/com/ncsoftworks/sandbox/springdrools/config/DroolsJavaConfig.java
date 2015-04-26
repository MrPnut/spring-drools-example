package com.ncsoftworks.sandbox.springdrools.config;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.spring.KModuleBeanFactoryPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Nick on 4/18/2015.
 */
@Profile("javaconfig")
@Configuration
@ComponentScan(basePackages = { "org.kie.spring.annotations" })
public class DroolsJavaConfig {

    @Bean(name = "kbase")
    public KieBase kbase() {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        kfs.write(kieServices.getResources().newClassPathResource("rules/org/drools/examples/ExamplePolicyPricing.xls"));

        KieBuilder builder = kieServices.newKieBuilder(kfs);
        Results results = builder.buildAll().getResults();

        if (results.hasMessages(Message.Level.ERROR)) {
            throw new IllegalStateException(results.getMessages(Message.Level.ERROR).toString());
        }

        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());

        return kieContainer.getKieBase();
    }

    @Autowired
    @Bean(name = "statelessKieSession")
    public StatelessKieSession statelessKieSession(KieBase kieBase) throws Exception {
        return kieBase.newStatelessKieSession();
    }

    @Bean
    public KModuleBeanFactoryPostProcessor kModuleBeanFactoryPostProcessor() {
        return new KModuleBeanFactoryPostProcessor();
    }
}
