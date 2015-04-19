package com.ncsoftworks.sandbox.springdrools.config;

import org.drools.KnowledgeBase;
import org.drools.builder.*;
import org.drools.builder.conf.impl.DecisionTableConfigurationImpl;
import org.drools.container.spring.beans.StatelessKnowledgeSessionBeanFactory;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Created by Nick on 4/18/2015.
 */
@Profile("javaconfig")
@Configuration
public class DroolsJavaConfig {
    @Bean(name = "kbase")
    public KnowledgeBase kbase() {
        DecisionTableConfigurationImpl decisionTableConfig = new DecisionTableConfigurationImpl();
        decisionTableConfig.setInputType(DecisionTableInputType.XLS);
        decisionTableConfig.setWorksheetName("Tables");
        KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        builder.add(ResourceFactory.newClassPathResource("rules/org/drools/examples/ExamplePolicyPricing.xls"),
                ResourceType.DTABLE,
                decisionTableConfig);

        return builder.newKnowledgeBase();
    }

    @Autowired
    @Bean(name = "statelessSession")
    public StatelessKnowledgeSessionBeanFactory statelessKnowledgeSession(KnowledgeBase knowledgeBase) throws Exception {
        StatelessKnowledgeSessionBeanFactory factory = new StatelessKnowledgeSessionBeanFactory();
        factory.setKbase(knowledgeBase);
        return factory;
    }
}
