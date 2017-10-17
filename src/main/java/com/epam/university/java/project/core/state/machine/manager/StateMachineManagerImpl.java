package com.epam.university.java.project.core.state.machine.manager;

import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;

/**
 * Implementation class for StateMachineManager.
 *
 * @author Sergei Titov
 */
public class StateMachineManagerImpl implements StateMachineManager {

    /**
     * {@inheritDoc}
     */
    @Override
    public StateMachineDefinition<?, ?> loadDefinition(Resource resource) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity, StateMachineDefinition<S, E> definition) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        return null;
    }
}
