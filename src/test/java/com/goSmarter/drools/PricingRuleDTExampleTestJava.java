package com.goSmarter.drools;

import com.ncsoftworks.sandbox.springdrools.config.DroolsJavaConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Nick on 4/19/2015.
 */
@ActiveProfiles("javaconfig")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DroolsJavaConfig.class)
public class PricingRuleDTExampleTestJava extends PricingRuleDTExampleTestSupport {
    @Test
    @Override
    public void testExecuteExample() throws Exception {
        super.testExecuteExample();
    }
}
