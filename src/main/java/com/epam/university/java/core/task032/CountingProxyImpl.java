package com.epam.university.java.core.task032;

import java.util.HashMap;
import java.util.Map;

public class CountingProxyImpl extends SomeActionExecutorImpl implements CountingProxy {

    private Map<String, Integer> invocations = new HashMap<>();

    /**
     * Get amount of method call.
     *
     * @param methodName method name
     * @return amount of call
     */
    @Override
    public int getInvocationsCount(String methodName) {
        return invocations.getOrDefault(methodName, 0);
    }


    /**
     * Do the action, not important for us.
     */
    @Override
    public void doAction() {
        invocations.put("doAction", invocations.getOrDefault("doAction", 0) + 1);
        super.doAction();
    }

    /**
     * Do another action, not important for us.
     */
    @Override
    public void doAnotherAction() {
        invocations.put("doAnotherAction", invocations.getOrDefault("doAnotherAction", 0) + 1);
        super.doAnotherAction();
    }
}
