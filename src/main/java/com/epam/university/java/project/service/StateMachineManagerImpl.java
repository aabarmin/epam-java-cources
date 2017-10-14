package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.core.state.machine.domain.StateMachineState;
import com.epam.university.java.project.core.state.machine.domain.StateMachineStateImpl;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

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
            final JAXBContext jaxbContext = JAXBContext.newInstance(
                    StateMachineDefinitionImpl.class,
                    StateMachineStateImpl.class
            );
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (StateMachineDefinitionImpl) unmarshaller.unmarshal(resource.getFile());
        } catch (JAXBException e) {
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
    @SuppressWarnings("unchecked")
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity, StateMachineDefinition<S, E> definition) {
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
    @Override
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        try {
            final StateMachineDefinition<S, E> definition = entity.getStateMachineDefinition();
            final StateMachineEventHandler handler = definition.getHandlerClass().newInstance();
            final Optional<StateMachineState<S, E>> optionalState = definition.getStates()
                    .stream()
                    .filter(s -> entity.getState().equals(s.getFrom()))
                    .filter(s -> event.equals(s.getOn()))
                    .findFirst();
            final String methodName;
            if (optionalState.isPresent()) {
                methodName = optionalState.get().getMethodToCall();
            } else {
                if (!definition.getStartEvent().equals(event)
                        || !definition.getStartState().equals(entity.getState())) {
                    throw new RuntimeException();
                }
                return entity;
            }
            final Optional<Method> toInvoke = Arrays.stream(handler.getClass().getDeclaredMethods())
                    .filter(m -> methodName.equals(m.getName()))
                    .findFirst();
            if (toInvoke.isPresent()) {
                return (StatefulEntity<S, E>) toInvoke.get().invoke(handler, entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

}
