package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;
import com.epam.university.java.project.service.StateMachineEventHandler;

import java.util.ArrayList;
import java.util.Collection;

public class StateMachineDefinitionImpl implements StateMachineDefinition<BookStatus, BookEvent> {

    private BookEvent startEvent;
    private BookStatus startState;
    private final Collection<StateMachineState<BookStatus, BookEvent>> states;
    private Class<? extends StateMachineEventHandler> handlerClass;

    public StateMachineDefinitionImpl() {
        states = new ArrayList<>();
    }

    @Override
    public BookEvent getStartEvent() {
        return startEvent;
    }

    @Override
    public BookStatus getStartState() {
        return startState;
    }

    @Override
    public void setStartEvent(BookEvent bookEvent) {
        this.startEvent = bookEvent;
    }

    @Override
    public void setStartState(BookStatus bookStatus) {
        this.startState = bookStatus;
    }

    @Override
    public Collection<StateMachineState<BookStatus, BookEvent>> getStates() {
        return states;
    }

    @Override
    public void addState(StateMachineState<BookStatus, BookEvent> state) {
        states.add(state);
    }

    @Override
    public Class<? extends StateMachineEventHandler> getHandlerClass() {
        return handlerClass;
    }

    @Override
    public void setHandlerClass(Class<? extends StateMachineEventHandler> handlerClass) {
        this.handlerClass = handlerClass;
    }
}
