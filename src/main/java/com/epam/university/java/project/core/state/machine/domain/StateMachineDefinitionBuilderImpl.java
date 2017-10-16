package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;
import com.epam.university.java.project.service.BookStateMachineHandler;
import java.util.ArrayList;
import java.util.Collection;

public class StateMachineDefinitionBuilderImpl
    implements StateMachineDefinitionBuilder<BookStatus, BookEvent> {

    private Collection<StateMachineState<BookStatus, BookEvent>> states = new ArrayList<>();


    @Override
    public StateMachineDefinition<BookStatus, BookEvent> build() {
        StateMachineDefinition<BookStatus, BookEvent> machine = new StateMachineDefinitionImpl();
        machine.setHandlerClass(BookStateMachineHandler.class);
        machine.setStartEvent(BookEvent.CREATE);
        machine.setStartState(BookStatus.DRAFT);
        states.forEach(machine::addState);
        return machine;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(BookStatus from,
        BookStatus to, BookEvent on, String method) {
        states.add(new StateMachineStateImpl());
        return this;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(BookStatus from,
        BookStatus to, BookEvent on) {
        states.add(new StateMachineStateImpl());
        return this;
    }
}
