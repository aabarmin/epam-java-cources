package com.epam.university.java.project.domain;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class BookImpl implements Book {
    int id;
    String title;
    Collection<String> authors;
    String serialNumber;
    LocalDate returnDate;
    BookStatus state = BookStatus.DRAFT;
    private StateMachineDefinition<BookStatus, BookEvent> stateMachineDefinition;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;

    }

    @Override
    public Collection<String> getAuthors() {
        return authors;
    }

    @Override
    public void setAuthors(Collection<String> authors) {
        this.authors = authors;

    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(String value) {
        this.serialNumber = value;

    }

    @Override
    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public void setReturnDate(LocalDate date) {
        this.returnDate = date;

    }

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
