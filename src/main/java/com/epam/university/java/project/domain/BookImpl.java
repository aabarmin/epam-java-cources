package com.epam.university.java.project.domain;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class BookImpl implements Book {
    private int id;
    private String title;
    private Collection<String> authors = new ArrayList<>();
    private String serialNumber;
    private LocalDate returnDate;
    private BookStatus bookStatus;
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
        serialNumber = value;
    }

    @Override
    public LocalDate getReturnDate() {
        return returnDate;
    }

    @Override
    public void setReturnDate(LocalDate date) {
        returnDate = date;
    }

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
        return stateMachineDefinition;
    }

    @Override
    public void setStateMachineDefinition(StateMachineDefinition<BookStatus,
            BookEvent> definition) {
        stateMachineDefinition = definition;
    }
}