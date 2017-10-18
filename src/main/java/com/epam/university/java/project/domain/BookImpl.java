package com.epam.university.java.project.domain;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Class implements <code>Booke</code> interface.
 */
public class BookImpl implements Book {
    private BookStatus bookStatus;
    private int id;
    private String title;
    private StateMachineDefinition<BookStatus, BookEvent>
            statusMachineDefinition;
    private Collection<String> authors;
    private String serialNumber;
    private LocalDate localDate;

    @Override
    public BookStatus getState() {
        return bookStatus;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setState(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
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
    public StateMachineDefinition<BookStatus, BookEvent>
        getStateMachineDefinition() {
        return statusMachineDefinition;
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
    public void setStateMachineDefinition(StateMachineDefinition<BookStatus,
            BookEvent> definition) {
        this.statusMachineDefinition = definition;
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
        return localDate;
    }

    @Override
    public void setReturnDate(LocalDate date) {
        this.localDate = date;
    }
}