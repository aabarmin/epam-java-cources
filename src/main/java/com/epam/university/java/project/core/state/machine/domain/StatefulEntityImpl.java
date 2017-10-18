package com.epam.university.java.project.core.state.machine.domain;


import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "bean")
public class StatefulEntityImpl implements StatefulEntity<BookStatus, BookEvent> {

    @XmlElement
    private BookStatus bookStatus;
    @XmlElement
    private StateMachineDefinition<BookStatus, BookEvent> definition;


    @Override
    public BookStatus getState() {
        return bookStatus;
    }

    @Override
    public void setState(BookStatus bookStatus) {
        this.bookStatus = bookStatus;

    }

    @Override
    public StateMachineDefinition<BookStatus, BookEvent> getStateMachineDefinition() {
        return definition;
    }

    @Override
    public void setStateMachineDefinition(StateMachineDefinition<BookStatus,
            BookEvent> definition) {
        this.definition = definition;

    }
}
