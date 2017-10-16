package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import java.util.ArrayList;
import java.util.Collection;

public class StateMachineDefinitionBuilderImpl implements
        StateMachineDefinitionBuilder<BookStatus, BookEvent> {

    private Collection<StateMachineState<BookStatus, BookEvent>> states = new ArrayList<>();


    @Override
    public StateMachineDefinition<BookStatus, BookEvent> build() {
        final StateMachineDefinitionImpl
                stateMachineDefinition = new StateMachineDefinitionImpl();
        states.forEach(stateMachineDefinition::addState);
        return stateMachineDefinition;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent>
        addState(BookStatus from, BookStatus to, BookEvent on, String method) {
        final StateMachineStateImpl e = new StateMachineStateImpl();
        e.setFrom(from);
        e.setTo(to);
        e.setMethodToCall(method);
        e.setOn(on);
        states.add(e);
        return this;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent>
        addState(BookStatus from, BookStatus to, BookEvent on) {
        final StateMachineStateImpl e = new StateMachineStateImpl();
        e.setFrom(from);
        e.setTo(to);
        e.setOn(on);
        states.add(e);
        return this;
    }
}
