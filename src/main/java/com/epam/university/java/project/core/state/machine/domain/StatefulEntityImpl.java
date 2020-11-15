package com.epam.university.java.project.core.state.machine.domain;

import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

public class StatefulEntityImpl implements StatefulEntity<BookStatus, BookEvent> {

    private BookStatus state;
    private StateMachineDefinition<BookStatus, BookEvent> stateMachineDefinition;

    @Override
    public BookStatus getState() {
        return state;
    }

    @Override
    public void setState(BookStatus bookStatus) {
        this.state = bookStatus;
    }

    @Override
    public StateMachineDefinition<BookStatus, BookEvent> getStateMachineDefinition() {
        return stateMachineDefinition;
    }

    @Override
    public void setStateMachineDefinition(StateMachineDefinition<BookStatus,
            BookEvent> definition) {
        this.stateMachineDefinition = definition;
    }
}
