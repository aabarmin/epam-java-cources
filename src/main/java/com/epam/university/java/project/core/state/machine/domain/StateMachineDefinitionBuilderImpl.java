package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import java.util.ArrayList;
import java.util.Collection;

public class StateMachineDefinitionBuilderImpl
        implements StateMachineDefinitionBuilder<BookStatus, BookEvent> {
    private Collection<StateMachineState<BookStatus, BookEvent>> states = new ArrayList<>();

    @Override
    public StateMachineDefinition<BookStatus, BookEvent> build() {
        final StateMachineDefinitionImpl
                stateMachineDefinition = new StateMachineDefinitionImpl();
        states.forEach(stateMachineDefinition::addState);
        return stateMachineDefinition;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(BookStatus from,
                                                                         BookStatus to,
                                                                         BookEvent on,
                                                                         String method) {
        final StateMachineStateImpl state = new StateMachineStateImpl();
        state.setFrom(from);
        state.setTo(to);
        state.setMethodToCall(method);
        state.setOn(on);
        states.add(state);
        return this;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(BookStatus from,
                                                                         BookStatus to,
                                                                         BookEvent on) {
        final StateMachineStateImpl state = new StateMachineStateImpl();
        state.setFrom(from);
        state.setTo(to);
        state.setOn(on);
        states.add(state);
        return this;
    }
}
