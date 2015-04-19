package com.ncsoftworks.sandbox.springdrools.controller;

import org.drools.KnowledgeBase;
import org.drools.kproject.KSession;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nick on 4/18/2015.
 */
@RestController
public class BreakpointController {

    @Autowired
    private KnowledgeBase knowledgeBase;

    @Autowired
    private StatelessKnowledgeSession statelessKnowledgeSession;

    @RequestMapping("/")
    public void breakpoint() {
        int i = 1;
    }
}
