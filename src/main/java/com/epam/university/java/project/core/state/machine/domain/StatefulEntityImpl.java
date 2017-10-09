package com.epam.university.java.project.core.state.machine.domain;

public class StatefulEntityImpl<STATE, EVENT> implements StatefulEntity<STATE, EVENT> {

    @Override
    public STATE getState() {
        return null;
    }

    @Override
    public void setState(STATE state) {

    }

    @Override
    public StateMachineDefinition<STATE, EVENT> getStateMachineDefinition() {
        return null;
    }

    @Override
    public void setStateMachineDefinition(StateMachineDefinition<STATE, EVENT> definition) {

    }
}
