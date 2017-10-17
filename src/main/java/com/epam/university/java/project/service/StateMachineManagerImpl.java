package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;

/**
 * Created by Александр on 17.10.2017.
 */
public class StateMachineManagerImpl implements StateMachineManager {
    /**
     * Read state machine definition from resource.
     *
     * @param resource resource with definition
     * @return state machine definition
     */
    @Override
    public StateMachineDefinition<?, ?> loadDefinition(Resource resource) {
        return null;
    }

    /**
     * Init new state machine in accordance with definition.
     *
     * @param entity     entity to create state
     * @param definition state machine definition
     * @return initialized stateful entity
     */
    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity, StateMachineDefinition<S, E> definition) {
        return null;
    }

    /**
     * Handle event for stateful entity with event handler.
     *
     * @param entity entity to update
     * @param event  event to handle
     * @return updated entity
     */
    @Override
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        return null;
    }
}
