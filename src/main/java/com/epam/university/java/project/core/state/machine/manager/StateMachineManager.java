package com.epam.university.java.project.core.state.machine.manager;

import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;

public interface StateMachineManager {
    /**
     * Read state machine definition from resource.
     * @param resource resource with definition
     * @return state machine definition
     */
    StateMachineDefinition<?, ?> loadDefinition(Resource resource);

    /**
     * Init new state machine in accordance with definition.
     * @param entity entity to create state
     * @param definition state machine definition
     * @param <S> state type
     * @param <E> event type
     * @return initialized stateful entity
     */
    <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity,
                                                 StateMachineDefinition<S, E> definition);
}
