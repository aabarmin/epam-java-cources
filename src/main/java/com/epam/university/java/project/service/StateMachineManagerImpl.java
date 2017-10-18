package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.domain.StateMachineState;
import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StateMachineManagerImpl implements StateMachineManager {
    private ExecutorService executor = Executors.newCachedThreadPool();

    @Override
    public StateMachineDefinition<?, ?> loadDefinition(Resource resource) {
        Future<StateMachineDefinition> submit = executor.submit(() -> {
            final JAXBContext jaxbContext = JAXBContext.newInstance(
                    StateMachineDefinitionImpl.class
            );
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (StateMachineDefinition) unmarshaller.unmarshal(resource.getFile());
        });
        try {
            return submit.get();
        } catch (Exception e) {
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
        Future<StatefulEntity<S, E>> submit = executor.submit(() -> {
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
                    throw new RuntimeException("Entity don't have a correct transaction to"
                            + event.toString());
                }
                return entity;
            }
            final Optional<Method> toInvoke = Arrays.stream(handler.getClass().getDeclaredMethods())
                    .filter(m -> methodName.equals(m.getName()))
                    .findFirst();
            if (toInvoke.isPresent()) {
                return (StatefulEntity<S, E>) toInvoke.get().invoke(handler, entity);
            }
            return entity;
        });


        try {
            return submit.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
