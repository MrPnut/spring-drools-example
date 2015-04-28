package com.goSmarter.drools;

import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KReleaseId;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.StatelessKieSession;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Nick on 4/19/2015.
 */
public abstract class PricingRuleDTExampleTestSupport {

    @KBase
    @KReleaseId(groupId = "com.ncsoftworks", artifactId = "policy-rules", version = "LATEST")
    private KieBase kieBase;

    public void testExecuteExample() throws Exception {
        Driver driver = new Driver();
        Policy policy = new Policy();

        kieBase.newStatelessKieSession().execute(Arrays.asList(new Object[]{driver, policy}));
        assertEquals(120, policy.getBasePrice());
    }

}
