package com.epam.university.java.project.core.state.machine.manager;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;

/**
 * Created by Romin Nuro on 27.09.2020 20:48.
 */
public class Tester {
    public static void main(String[] args) {
        StateMachineManager machineManager = new StateMachineManagerImpl();
        final String contextPath = Tester.class.getResource("/project/DefaultBookStateMachineDefinition.xml").getFile();
        StateMachineDefinition<?, ?> stateMachineDefinition = machineManager.loadDefinition(new XmlResource(contextPath));
        int x = 10;
    }
}
