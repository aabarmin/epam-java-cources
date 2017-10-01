package com.epam.university.java.project.core.state.machine.domain;

/**
 * State machine definition builder.
 * @param <STATE> state type
 * @param <EVENT> event type
 */
public interface StateMachineDefinitionBuilder<STATE, EVENT> {
    /**
     * Build state machine definition.
     * @return built definition
     */
    StateMachineDefinition<STATE, EVENT> build();

    /**
     * Add state to definition.
     * @param from from state
     * @param to to state
     * @param on event
     * @param method method to call
     * @return builder
     */
    StateMachineDefinitionBuilder<STATE, EVENT> addState(
            STATE from,
            STATE to,
            EVENT on,
            String method
    );

    /**
     * Add state to definition.
     * @param from from state
     * @param to to state
     * @param on event
     * @return builder
     */
    StateMachineDefinitionBuilder<STATE, EVENT> addState(
            STATE from,
            STATE to,
            EVENT on
    );
}
