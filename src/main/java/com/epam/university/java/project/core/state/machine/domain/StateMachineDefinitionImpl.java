package com.epam.university.java.project.core.state.machine.domain;

import java.util.Collection;

/**
 * Implementation class for StateMachineDefinition.
 *
 * @author Sergei Titov
 */
public class StateMachineDefinitionImpl implements StateMachineDefinition {

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getStartEvent() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getStartState() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartEvent(Object o) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStartState(Object o) {

    }

    @Override
    public Collection<StateMachineState> getStates() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addState(StateMachineState state) {

    }

    @Override
    public Class<? extends StateMachineEventHandler> getHandlerClass() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHandlerClass(Class handlerClass) {

    }
}
