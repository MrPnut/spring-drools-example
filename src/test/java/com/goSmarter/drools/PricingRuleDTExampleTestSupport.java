package com.goSmarter.drools;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.StatelessKieSession;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nick on 4/19/2015.
 */
public abstract class PricingRuleDTExampleTestSupport {

    @KSession("statelessKieSession")
    private StatelessKieSession statelessKnowledgeSession;

    public void testExecuteExample() throws Exception {
        Driver driver = new Driver();
        Policy policy = new Policy();

        statelessKnowledgeSession.execute(Arrays.asList(new Object[]{driver, policy}));
        assertEquals(120, policy.getBasePrice());
    }

}
