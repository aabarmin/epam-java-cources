package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

public class StateMachineDefinitionBuilderImpl implements
        StateMachineDefinitionBuilder<BookStatus, BookEvent> {
    private final StateMachineDefinition<BookStatus, BookEvent> stateMachineDefinition;

    public StateMachineDefinitionBuilderImpl() {
        this.stateMachineDefinition = new StateMachineDefinitionImpl();
    }

    @Override
    public StateMachineDefinition<BookStatus, BookEvent> build() {
        return stateMachineDefinition;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(
            BookStatus from, BookStatus to, BookEvent on, String method) {
        StateMachineStateImpl stateMachineState = new StateMachineStateImpl(from, to, on, method);
        stateMachineDefinition.addState(stateMachineState);
        return this;
    }

    @Override
    public StateMachineDefinitionBuilder<BookStatus, BookEvent> addState(
            BookStatus from, BookStatus to, BookEvent on) {
        StateMachineStateImpl stateMachineState = new StateMachineStateImpl(from, to, on);
        stateMachineDefinition.addState(stateMachineState);
        return this;
    }
}
