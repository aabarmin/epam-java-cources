package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Proxy implementation.
 */
public class CountingProxyImpl implements CountingProxy, SomeActionExecutor {

    private SomeActionExecutor exec;
    private Map<String, Integer> invokeMap;

    /**
     * Constructs counting proxy and initializes counting map.
     */
    public CountingProxyImpl() {
        invokeMap = new HashMap<>();
        for (Method method : getClass().getDeclaredMethods()) {
            invokeMap.put(method.getName(), 0);
        }
    }

    /**
     * Get amount of method call.
     * @param methodName method name
     * @return amount of call
     */
    @Override
    public int getInvocationsCount(String methodName) {
        return invokeMap.getOrDefault(methodName, 0);
    }

    /**
     * Do the action, not important for us.
     */
    @Override
    public void doAction() {
        count();
        System.out.println(
            String.format(
                "proxy executor [id: %d] doAction called",
                System.identityHashCode(this)
            )
        );
        exec.doAction();
    }

    /**
     * Do another action, not important for us.
     */
    @Override
    public void doAnotherAction() {
        count();
        System.out.println(
            String.format(
                "proxy executor [id: %d] doAnotherAction called",
                System.identityHashCode(this)
            )
        );
        exec.doAnotherAction();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (exec == null) {
            exec = new SomeActionExecutorImpl();
        }
        return method.invoke(this, args);
    }

    /**
     * Increment an invocation count for calling method.
     */
    private void count() {
        // indices: 0 - StackTrace, 1 - this method, 2 - calling method
        // 3 - calling method of calling method and so on
        final String methodName = getMethodName(2);
        invokeMap.compute(methodName, (k, v) -> ++v);
    }

    /**
     * Get method name from stack trace.
     * @param depth search depth
     * @return method name
     */
    private String getMethodName(int depth) {
        return Thread.currentThread().getStackTrace()[1 + depth].getMethodName();
    }

}
