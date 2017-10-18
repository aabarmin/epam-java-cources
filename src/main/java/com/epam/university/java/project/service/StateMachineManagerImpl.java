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
import java.util.Optional;

public class StateMachineManagerImpl implements StateMachineManager {
    /**
     * Default constructor.
     */
    public StateMachineManagerImpl() {
    }

    @Override
    public StateMachineDefinition<?, ?> loadDefinition(Resource resource) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(
                    StateMachineDefinitionImpl.class,
                    StateMachineStateImpl.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (StateMachineDefinition) unmarshaller.unmarshal(resource.getFile());
        } catch (JAXBException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity,
                                                        StateMachineDefinition<S, E> definition) {
        entity.setStateMachineDefinition(definition);
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        try {
            StateMachineEventHandler handler = entity.getStateMachineDefinition()
                    .getHandlerClass().newInstance();
            Optional<StateMachineState<S, E>> state =
                    entity.getStateMachineDefinition().getStates().stream()
                    .filter(s -> entity.getState().equals(s.getFrom()))
                    .filter(s -> event.equals(s.getOn()))
                    .findFirst();
            if (!state.isPresent()) {
                return entity;
            }
            String methodToCall = state.get().getMethodToCall();
            return (StatefulEntity<S, E>) handler.getClass()
                    .getDeclaredMethod(methodToCall, entity.getClass()).invoke(handler, entity);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
