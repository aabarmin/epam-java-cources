package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StateMachineState;
import com.epam.university.java.project.core.state.machine.domain.StateMachineStateImpl;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class StateMachineManagerImpl implements StateMachineManager {

    @Override
    public StateMachineDefinition<?, ?> loadDefinition(Resource resource) {
        StateMachineDefinition<BookStatus, BookEvent> definition = new StateMachineDefinitionImpl();

        File file = resource.getFile();
        XMLInputFactory factory = XMLInputFactory.newFactory();
        XMLEventReader eventReader;
        try {
            eventReader = factory.createXMLEventReader(new FileInputStream(file));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                if (event.isStartElement()) {
                    StartElement startElement = event.asStartElement();

                    String startElementName = startElement.getName().getLocalPart();

                    if ("definition".equalsIgnoreCase(startElementName)) {
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();
                            if ("startState".equalsIgnoreCase(attribute.getName().getLocalPart())) {
                                String value = attribute.getValue();
                                if ("draft".equalsIgnoreCase(value)) {
                                    definition.setStartState(BookStatus.DRAFT);
                                } else if ("accounted".equalsIgnoreCase(value)) {
                                    definition.setStartState(BookStatus.ACCOUNTED);
                                } else if ("issued".equalsIgnoreCase(value)) {
                                    definition.setStartState(BookStatus.ISSUED);
                                }
                            }
                            if ("startEvent".equalsIgnoreCase(attribute.getName().getLocalPart())) {
                                String value = attribute.getValue();
                                if ("create".equalsIgnoreCase(value)) {
                                    definition.setStartEvent(BookEvent.CREATE);
                                } else if ("accept".equalsIgnoreCase(value)) {
                                    definition.setStartEvent(BookEvent.ACCEPT);
                                } else if ("issue".equalsIgnoreCase(value)) {
                                    definition.setStartEvent(BookEvent.ISSUE);
                                } else if ("return".equalsIgnoreCase(value)) {
                                    definition.setStartEvent(BookEvent.RETURN);
                                }
                            }
                            if ("handler".equalsIgnoreCase(attribute.getName().getLocalPart())) {
                                String value = attribute.getValue();
                                Class<? extends StateMachineEventHandler> handlerClass
                                        = (Class<? extends StateMachineEventHandler>)
                                        Class.forName(value);
                                definition.setHandlerClass(handlerClass);
                            }
                        }
                    }
                    if ("transition".equalsIgnoreCase(startElementName)) {
                        StateMachineState<BookStatus, BookEvent> state
                                = new StateMachineStateImpl();
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {
                            Attribute attribute = attributes.next();

                            if ("from".equalsIgnoreCase(attribute.getName().getLocalPart())) {
                                String value = attribute.getValue();
                                if ("draft".equalsIgnoreCase(value)) {
                                    state.setFrom(BookStatus.DRAFT);
                                } else if ("accounted".equalsIgnoreCase(value)) {
                                    state.setFrom(BookStatus.ACCOUNTED);
                                } else if ("issued".equalsIgnoreCase(value)) {
                                    state.setFrom(BookStatus.ISSUED);
                                }
                            }
                            if ("to".equalsIgnoreCase(attribute.getName().getLocalPart())) {
                                String value = attribute.getValue();
                                if ("draft".equalsIgnoreCase(value)) {
                                    state.setTo(BookStatus.DRAFT);
                                } else if ("accounted".equalsIgnoreCase(value)) {
                                    state.setTo(BookStatus.ACCOUNTED);
                                } else if ("issued".equalsIgnoreCase(value)) {
                                    state.setTo(BookStatus.ISSUED);
                                }
                            }
                            if ("on".equalsIgnoreCase(attribute.getName().getLocalPart())) {
                                String value = attribute.getValue();
                                if ("create".equalsIgnoreCase(value)) {
                                    state.setOn(BookEvent.CREATE);
                                } else if ("accept".equalsIgnoreCase(value)) {
                                    state.setOn(BookEvent.ACCEPT);
                                } else if ("issue".equalsIgnoreCase(value)) {
                                    state.setOn(BookEvent.ISSUE);
                                } else if ("return".equalsIgnoreCase(value)) {
                                    state.setOn(BookEvent.RETURN);
                                }
                            }
                            if ("call".equalsIgnoreCase(attribute.getName().getLocalPart())) {
                                String value = attribute.getValue();
                                state.setMethodToCall(value);
                            }
                        }
                        definition.addState(state);
                    }
                }
            }


        } catch (FileNotFoundException | XMLStreamException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return definition;
    }

    @Override
    public <S, E> StatefulEntity<S, E> initStateMachine(StatefulEntity<S, E> entity,
                                                        StateMachineDefinition<S, E> definition) {
        entity.setStateMachineDefinition(definition);
        return entity;
    }

    @Override
    public <S, E> StatefulEntity<S, E> handleEvent(StatefulEntity<S, E> entity, E event) {
        try {
            StateMachineDefinition<S, E> stateMachineDefinition
                    = entity.getStateMachineDefinition();
            StateMachineEventHandler handler = stateMachineDefinition.getHandlerClass()
                    .getDeclaredConstructor().newInstance();


            StateMachineState stateMachineState = null;
            for (StateMachineState state : stateMachineDefinition.getStates()) {
                if (state.getFrom().equals(entity.getState())
                        && state.getOn().equals(event)) {
                    stateMachineState = state;
                    break;
                }
            }

            if (stateMachineState != null) {
                String methodToCall = stateMachineState.getMethodToCall();
                Method[] methods = handler.getClass().getMethods();

                for (Method method : methods) {
                    if (method.getName().equalsIgnoreCase(methodToCall)) {
                        entity = (StatefulEntity<S, E>) method.invoke(handler, entity);
                        break;
                    }
                }
            }

            return entity;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
