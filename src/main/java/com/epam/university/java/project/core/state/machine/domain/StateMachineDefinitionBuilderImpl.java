package com.epam.university.java.project.core.state.machine.domain;

/**
 * Implementation class for StateMachineDefinitionBuilder.
 *
 * @author Sergei Titov
 */
public class StateMachineDefinitionBuilderImpl implements StateMachineDefinitionBuilder {

    /**
     * {@inheritDoc}
     */
    @Override
    public StateMachineDefinition build() {
        return new StateMachineDefinitionImpl();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StateMachineDefinitionBuilder addState(Object from, Object to, Object on, String method) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StateMachineDefinitionBuilder addState(Object from, Object to, Object on) {
        return null;
    }
}
