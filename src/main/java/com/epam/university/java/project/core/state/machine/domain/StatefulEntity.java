package com.epam.university.java.project.core.state.machine.domain;

/**
 * Entity with state support.
 * @param <STATE> state description type
 * @param <EVENT> event description type
 */
public interface StatefulEntity<STATE, EVENT> {
    /**
     * Get current entity state.
     * @return state value
     */
    STATE getState();

    /**
     * Set current entity state.
     * @param state state value
     */
    void setState(STATE state);

    /**
     * Get definition of state machine for current entity.
     * @return state machine definition
     */
    StateMachineDefinition<STATE, EVENT> getStateMachineDefinition();

    /**
     * Set definition of state machine for current entity.
     * @param definition state machine definition
     */
    void setStateMachineDefinition(StateMachineDefinition<STATE, EVENT> definition);
}
