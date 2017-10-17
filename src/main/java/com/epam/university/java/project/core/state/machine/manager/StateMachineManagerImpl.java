package com.epam.university.java.project.core.state.machine.manager;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBContext;

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

        StateMachineDefinition stateMachineDefinition = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(
                    StateMachineDefinitionImpl.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            stateMachineDefinition = (StateMachineDefinition) unmarshaller
                    .unmarshal(resource.getFile());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stateMachineDefinition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity,
                                                        StateMachineDefinition<S, E> definition) {

        entity.setStateMachineDefinition(definition);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {

        try {
            // get book's state machine
            final StateMachineDefinition<S, E> definition = entity.getStateMachineDefinition();
            if (null == definition) {
                return null;
            }
            // get handler name
            StateMachineEventHandler handlerName = definition.getHandlerClass().newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
