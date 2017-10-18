package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.core.state.machine.domain.StateMachineState;
import com.epam.university.java.project.core.state.machine.domain.StateMachineStateImpl;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.BookEvent;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public class StateMachineManagerImpl implements StateMachineManager {
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

    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity,
                                                        StateMachineDefinition<S, E> definition) {
        entity.setStateMachineDefinition(definition);
        return entity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        final StateMachineDefinition<S, E> stateMachineDefinition;
        if (event == BookEvent.CREATE) {
            stateMachineDefinition =
                    (StateMachineDefinition<S, E>) loadDefinition(new XmlResource(getClass()
                            .getResource("/project/DefaultBookStateMachineDefinition.xml")
                            .getFile()));
            initStateMachine(entity, stateMachineDefinition);
        } else {
            stateMachineDefinition = entity.getStateMachineDefinition();
        }
        final Class<? extends StateMachineEventHandler> handlerClass
                = stateMachineDefinition.getHandlerClass();
        final StateMachineEventHandler handler;
        try {
            handler = handlerClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String method = "";
        S to = null;
        if (event.equals(stateMachineDefinition.getStartEvent())) {
            method = "onCreate";
            to = stateMachineDefinition.getStartState();
        } else {
            for (StateMachineState<S, E> state : stateMachineDefinition.getStates()) {
                if (event.equals(state.getOn())
                        && entity.getState().equals(state.getFrom())) {
                    method = state.getMethodToCall();
                    to = state.getTo();
                }
            }
        }
        if ("".equals(method)) {
            throw new RuntimeException("Incorrect using of state machine");
        }
        try {
            return (StatefulEntity<S, E>)
                    handlerClass
                            .getMethod(method, entity.getClass(), to.getClass())
                            .invoke(handler, entity, to);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}