package com.ncsoftworks.sandbox.springdrools.controller;

import com.goSmarter.drools.Driver;
import com.goSmarter.drools.Policy;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KReleaseId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ncavallo on 4/28/2015.
 */
@RestController
public class PolicyController {

    @KReleaseId(groupId = "com.ncsoftworks", artifactId = "policy-rules", version = "LATEST")
    @KBase
    private KieBase kieBase;

    @RequestMapping("/policy/test")
    public Map<String, Object> testPolicy() {
        Map<String, Object> model = new HashMap<>();

        Driver driver = new Driver();
        Policy policy = new Policy();

        kieBase.newStatelessKieSession().execute(Arrays.asList(new Object[]{driver, policy}));

        model.put("policy", policy);
        return model;
    }
}
