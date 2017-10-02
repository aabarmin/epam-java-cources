package com.epam.university.java.project.core.state.machine.domain;

import java.util.Collection;

/**
 * State machine definition.
 */
public interface StateMachineDefinition<STATE, EVENT> {
    /**
     * Get start event.
     * @return event name
     */
    EVENT getStartEvent();

    /**
     * Get start state.
     * @return state name
     */
    STATE getStartState();

    /**
     * Set start event.
     * @param event event name
     */
    void setStartEvent(EVENT event);

    /**
     * Set start state.
     * @param state state name
     */
    void setStartState(STATE state);

    /**
     * Get state machine states collection.
     * @return states
     */
    Collection<StateMachineState<STATE, EVENT>> getStates();

    /**
     * Add state to state machine definition.
     * @param state state to add
     */
    void addState(StateMachineState<STATE, EVENT> state);

    /**
     * Get state machine handler class.
     * @return handler class
     */
    Class<? extends StateMachineEventHandler> getHandlerClass();

    /**
     * Set state machine handler class.
     * @param handlerClass handler class
     */
    void setHandlerClass(Class<? extends StateMachineEventHandler> handlerClass);
}
