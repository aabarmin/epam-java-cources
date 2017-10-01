package com.epam.university.java.project.core.state.machine.domain;

/**
 * State machine state.
 * @param <TYPE> state type
 * @param <EVENT> event type
 */
public interface StateMachineState<TYPE, EVENT> {
    /**
     * From state.
     * @return state name
     */
    TYPE getFrom();

    /**
     * Set from state.
     * @param state state name
     */
    void setFrom(TYPE state);

    /**
     * Get to state.
     * @return state name
     */
    TYPE getTo();

    /**
     * Set to state.
     * @param state state name
     */
    void setTo(TYPE state);

    /**
     * Get event.
     * @return event name
     */
    EVENT getOn();

    /**
     * Set event name.
     * @param event event name
     */
    void setOn(EVENT event);

    /**
     * Get method name to call on event. Method should exists in event handler.
     * @return method name
     */
    String getMethodToCall();

    /**
     * Set method name to call on event.
     * @param method method name
     */
    void setMethodToCall(String method);
}
