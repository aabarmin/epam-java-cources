package com.epam.university.java.project.domain;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static com.epam.university.java.project.domain.BookStatus.DRAFT;

/**
 * Implementation class for Book.
 *
 * @author Sergei Titov
 */
public class BookImpl implements Book {

    private int id = 0;
    private String title;
    private String serial;

    private LocalDate returnDate;

    private ArrayList<String> authors = new ArrayList<>();

    private BookStatus status = DRAFT;

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<String> getAuthors() {
        return authors;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAuthors(Collection<String> authors) {
        this.authors.addAll(authors);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSerialNumber() {
        return serial;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSerialNumber(String value) {
        this.serial = serial;
    }

    @Override
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setReturnDate(LocalDate date) {
        this.returnDate = returnDate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BookStatus getState() {

        return status;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setState(BookStatus bookStatus) {

        this.status = bookStatus;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StateMachineDefinition<BookStatus, BookEvent> getStateMachineDefinition() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStateMachineDefinition(StateMachineDefinition<BookStatus,
                                          BookEvent> definition) {

    }
}
