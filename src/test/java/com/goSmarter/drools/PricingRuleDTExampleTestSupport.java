package com.goSmarter.drools;

import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nick on 4/19/2015.
 */
public abstract class PricingRuleDTExampleTestSupport {

    @Autowired
    private StatelessKnowledgeSession statelessKnowledgeSession;

    public void testExecuteExample() throws Exception {
        Driver driver = new Driver();
        Policy policy = new Policy();

        statelessKnowledgeSession.execute(Arrays.asList(new Object[]{driver, policy}));
        assertEquals(120, policy.getBasePrice());
    }

}
