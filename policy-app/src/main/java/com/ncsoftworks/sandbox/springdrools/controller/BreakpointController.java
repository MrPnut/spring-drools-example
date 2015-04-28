package com.ncsoftworks.sandbox.springdrools.controller;

import org.kie.api.KieBase;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nick on 4/18/2015.
 */
@RestController
public class BreakpointController {

    @Autowired
    private KieBase knowledgeBase;

    @Autowired
    private StatelessKieSession statelessKnowledgeSession;

    @RequestMapping("/")
    public void breakpoint() {
        int i = 1;
    }
}
