package com.epam.university.java.project.core.state.machine.domain;

import java.util.Collection;

public class StateMachineDefinitionImpl<STATE, EVENT> implements StateMachineDefinition<STATE, EVENT> {
    @Override
    public EVENT getStartEvent() {
        return null;
    }

    @Override
    public STATE getStartState() {
        return null;
    }

    @Override
    public void setStartEvent(EVENT event) {

    }

    @Override
    public void setStartState(STATE state) {

    }

    @Override
    public Collection<StateMachineState<STATE, EVENT>> getStates() {
        return null;
    }

    @Override
    public void addState(StateMachineState<STATE, EVENT> state) {

    }

    @Override
    public Class<? extends StateMachineEventHandler> getHandlerClass() {
        return null;
    }

    @Override
    public void setHandlerClass(Class<? extends StateMachineEventHandler> handlerClass) {

    }
}
