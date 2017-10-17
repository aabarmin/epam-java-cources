package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.core.state.machine.domain.StateMachineState;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class StateMachineManagerImpl implements StateMachineManager {
    /**
     * Read state machine definition from resource.
     *
     * @param resource resource with definition
     * @return state machine definition
     */
    @Override
    public StateMachineDefinition<?, ?> loadDefinition(Resource resource) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StateMachineDefinitionImpl.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            return (StateMachineDefinition) unmarshaller.unmarshal(resource.getFile());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Init new state machine in accordance with definition.
     *
     * @param entity     entity to create state
     * @param definition state machine definition
     * @return initialized stateful entity
     */
    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity,
                                                        StateMachineDefinition<S, E> definition) {
        entity.setStateMachineDefinition(definition);
        return entity;
    }

    /**
     * Handle event for stateful entity with event handler.
     *
     * @param entity entity to update
     * @param event  event to handle
     * @return updated entity
     */
    @SuppressWarnings("unchecked")
    @Override
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        try {
            StateMachineDefinition<S, E> definition = entity.getStateMachineDefinition();
            StateMachineEventHandler handler = definition.getHandlerClass().newInstance();

            //invoke method according to event
            for (StateMachineState<S, E> state : definition.getStates()) {
                if (state.getFrom().equals(entity.getState()) && state.getOn().equals(event)) {
                    return (StatefulEntity<S, E>) handler
                            .getClass()
                            .getMethod(state.getMethodToCall(), Book.class)
                            .invoke(handler, (Book) entity);
                }
            }

            return entity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
