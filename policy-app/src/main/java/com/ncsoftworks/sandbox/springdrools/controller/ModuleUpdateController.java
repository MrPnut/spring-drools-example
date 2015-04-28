package com.ncsoftworks.sandbox.springdrools.controller;

import org.drools.compiler.kie.builder.impl.KieContainerImpl;
import org.drools.compiler.kproject.ReleaseIdImpl;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nick on 4/18/2015.
 */
@RestController
public class ModuleUpdateController {

    @Autowired
    private ListableBeanFactory beanFactory;

    @RequestMapping("/modules")
    public Map<String, Object> displayLoadedModules() {
        Map<String, Object> model = new HashMap<>();
        model.put("modules",  getContainersFromBeanFactory());
        return model;
    }

    @RequestMapping("/modules/{group}/{artifact}/update")
    public void updateModule(@PathVariable("group") String group,
                             @PathVariable("artifact") String artifact,
                             @RequestParam(value = "version", required = true) String version) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieContainer(new ReleaseIdImpl(group, artifact, "LATEST"));
        kieContainer.updateToVersion(new ReleaseIdImpl(group, artifact, version));
    }

    private Map<String, KieContainerImpl> getContainersFromBeanFactory() {
        Map<String, KieContainerImpl> containers = beanFactory.getBeansOfType(KieContainerImpl.class);
        return containers != null ? Collections.unmodifiableMap(containers) : Collections.unmodifiableMap(new HashMap<>());
    }
}
