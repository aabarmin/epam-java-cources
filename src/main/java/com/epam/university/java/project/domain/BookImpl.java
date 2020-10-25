package com.epam.university.java.project.domain;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

public class BookImpl implements Book {
    private int mId;
    private String mTitle;
    private Collection<String> mAuthors;
    private String mSerialNumber;
    private LocalDate mDate;
    private BookStatus mBookStatus;
    private StateMachineDefinition<BookStatus, BookEvent> mStateMachineDefinition;

    @Override
    public int getId() {
        return mId;
    }

    @Override
    public void setId(int id) {
        this.mId = id;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public void setTitle(String title) {
        this.mTitle = title;
    }

    @Override
    public Collection<String> getAuthors() {
        return mAuthors;
    }

    @Override
    public void setAuthors(Collection<String> authors) {
        this.mAuthors = authors;
    }

    @Override
    public String getSerialNumber() {
        return mSerialNumber;
    }

    @Override
    public void setSerialNumber(String value) {
        this.mSerialNumber = value;
    }

    @Override
    public LocalDate getReturnDate() {
        return mDate;
    }

    @Override
    public void setReturnDate(LocalDate date) {
        this.mDate = date;
    }

    @Override
    public BookStatus getState() {
        return mBookStatus;
    }

    @Override
    public void setState(BookStatus bookStatus) {
        this.mBookStatus = bookStatus;
    }

    @Override
    public StateMachineDefinition<BookStatus, BookEvent> getStateMachineDefinition() {
        return mStateMachineDefinition;
    }

    @Override
    public void setStateMachineDefinition(StateMachineDefinition<BookStatus, BookEvent> definition) {
        this.mStateMachineDefinition = definition;
    }
}
