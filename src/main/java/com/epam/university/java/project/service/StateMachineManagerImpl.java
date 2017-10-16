package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.core.state.machine.domain.StateMachineState;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class StateMachineManagerImpl implements StateMachineManager {

    @Override
    public StateMachineDefinition<?, ?> loadDefinition(Resource resource) {
        if (!(resource instanceof XmlResource)) {
            throw new IllegalArgumentException("This is not XML resource");
        }
        StateMachineDefinition stateMachineDefinition = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(StateMachineDefinitionImpl.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            stateMachineDefinition = (StateMachineDefinition) unmarshaller
                .unmarshal(resource.getFile());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return stateMachineDefinition;
    }

    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity,
        StateMachineDefinition<S, E> definition) {
        entity.setStateMachineDefinition(definition);
        return entity;
    }

    @Override
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        StateMachineDefinition<S, E> machineDefinition = entity.getStateMachineDefinition();
        Collection<StateMachineState<S, E>> stateMachineStates = machineDefinition.getStates();
        Optional<StateMachineState<S, E>> result = stateMachineStates.stream()
            .filter(s -> s.getFrom().equals(entity.getState())
                && s.getOn().equals(event))
            .findAny();
        if (result.isPresent()) {
            String method = result.get().getMethodToCall();
            Class<? extends StateMachineEventHandler> handlerClass = machineDefinition
                .getHandlerClass();
            try {
                Method declaredMethod = Stream.of(handlerClass.getDeclaredMethods())
                    .filter(m -> m.getName().equals(method))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
                declaredMethod.invoke(handlerClass.newInstance(), entity);
            } catch (InvocationTargetException
                | InstantiationException
                | IllegalAccessException e) {
                e.printStackTrace();
            }
        } else {
            if (event.equals(machineDefinition.getStartEvent())
                && machineDefinition.getStartState().equals(entity.getState())) {
                return entity;
            } else {
                throw new IllegalArgumentException("Action isn't possible");
            }
        }

        return entity;
    }
}
