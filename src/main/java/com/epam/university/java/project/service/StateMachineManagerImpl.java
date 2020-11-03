package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StateMachineEventHandler;
import com.epam.university.java.project.core.state.machine.domain.StateMachineState;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

public class StateMachineManagerImpl implements StateMachineManager {


    @Override
    public StateMachineDefinition<?, ?> loadDefinition(Resource resource) {
        XmlStateMachineHandler xmlStateMachineHandler = new XmlStateMachineHandler();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(resource.getFile(), xmlStateMachineHandler);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
        StateMachineDefinitionImpl stateMachineDefinition =
                xmlStateMachineHandler.getStateMachineDefinition();
        stateMachineDefinition.setHandlerClass(BookStateMachineHandler.class);
        return stateMachineDefinition;
    }

    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity,
                                                        StateMachineDefinition<S, E> definition) {
        entity.setStateMachineDefinition(definition);
        entity.setState(definition.getStartState());
        return entity;
    }

    @Override
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        StateMachineDefinition<S, E> stateMachineDefinition = entity.getStateMachineDefinition();
        Class<? extends StateMachineEventHandler> handlerClass =
                stateMachineDefinition.getHandlerClass();
        Collection<StateMachineState<S, E>> states = stateMachineDefinition.getStates();
        S currentState = entity.getState();
        for (StateMachineState<S, E> state : states) {
            if (state.getFrom().equals(currentState)) {
                if (state.getOn().equals(event)) {
                    Method[] declaredMethods = handlerClass.getDeclaredMethods();
                    String methodToCall = state.getMethodToCall();
                    for (Method declaredMethod : declaredMethods) {
                        if (declaredMethod.getName().equals(methodToCall)) {
                            try {
                                StateMachineEventHandler stateMachineEventHandler = handlerClass
                                        .getDeclaredConstructor()
                                        .newInstance();
                                declaredMethod.invoke(stateMachineEventHandler, entity);
                            } catch (IllegalAccessException
                                    | InvocationTargetException
                                    | NoSuchMethodException
                                    | InstantiationException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return entity;
    }
}
