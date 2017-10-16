package com.epam.university.java.project.core.state.machine.domain;

public class StateMachineDefinitionBuilderImpl<STATE, EVENT> implements StateMachineDefinitionBuilder<STATE, EVENT> {


    @Override
    public StateMachineDefinition<STATE, EVENT> build() {
        return null;
    }

    @Override
    public StateMachineDefinitionBuilder<STATE, EVENT> addState(STATE from, STATE to, EVENT on,
        String method) {
        return null;
    }

    @Override
    public StateMachineDefinitionBuilder<STATE, EVENT> addState(STATE from, STATE to, EVENT on) {
        return null;
    }
}
