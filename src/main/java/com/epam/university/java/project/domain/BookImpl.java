package com.epam.university.java.project.domain;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by Александр on 17.10.2017.
 * Book domain object interface.
 */
public class BookImpl implements Book {
    private int id;
    private BookStatus bookStatus;
    private String title;
    private Collection<String> authors;
    private String serialNumber;
    private LocalDate returnDate;
    private StateMachineDefinition<BookStatus, BookEvent> stateMachineDefinition;

    /**
     * Get current entity state.
     *
     * @return state value
     */
    @Override
    public BookStatus getState() {
        return bookStatus;
    }

    /**
     * Set current entity state.
     *
     * @param bookStatus state value
     */
    @Override
    public void setState(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    /**
     * Get definition of state machine for current entity.
     *
     * @return state machine definition
     */
    @Override
    public StateMachineDefinition<BookStatus, BookEvent> getStateMachineDefinition() {
        return stateMachineDefinition;
    }

    /**
     * Set definition of state machine for current entity.
     *
     * @param definition state machine definition
     */
    @Override
    public void setStateMachineDefinition(
            StateMachineDefinition<BookStatus,
            BookEvent> definition) {
        this.stateMachineDefinition = definition;
    }

    /**
     * Get the book id.
     *
     * @return book id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Set the book id.
     *
     * @param id book id
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the book title.
     *
     * @return book title
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Set the book title.
     *
     * @param title book title
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get book authors.
     *
     * @return book authors
     */
    @Override
    public Collection<String> getAuthors() {
        return authors;
    }

    /**
     * Set book authors.
     *
     * @param authors book authors
     */
    @Override
    public void setAuthors(Collection<String> authors) {
        this.authors = authors;
    }

    /**
     * Get book serial number.
     *
     * @return number value
     */
    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Set book serial number.
     *
     * @param value number value
     */
    @Override
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

    /**
     * Get return date for issued book.
     *
     * @return return date
     */
    @Override
    public LocalDate getReturnDate() {
        return returnDate;
    }

    /**
     * Set return date for issued book.
     *
     * @param date return date
     */
    @Override
    public void setReturnDate(LocalDate date) {
        this.returnDate = date;
    }
}
