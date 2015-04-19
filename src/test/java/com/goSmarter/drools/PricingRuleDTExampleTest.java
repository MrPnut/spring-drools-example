package com.goSmarter.drools;

import com.ncsoftworks.sandbox.springdrools.config.DroolsJavaConfig;
import org.drools.runtime.StatelessKnowledgeSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nick on 4/19/2015.
 */
@ActiveProfiles("javaconfig")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DroolsJavaConfig.class)
public class PricingRuleDTExampleTest {

    @Autowired
    private StatelessKnowledgeSession statelessKnowledgeSession;

    @Test
    public void testExecuteExample() throws Exception {
        Driver driver = new Driver();
        Policy policy = new Policy();

        statelessKnowledgeSession.execute(Arrays.asList(new Object[] {driver, policy}));
        assertEquals(120, policy.getBasePrice());
    }
}
