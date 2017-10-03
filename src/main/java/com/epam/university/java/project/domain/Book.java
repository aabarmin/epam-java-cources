package com.epam.university.java.project.domain;

import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Book domain object interface.
 */
public interface Book extends StatefulEntity<BookStatus, BookEvent> {
    /**
     * Get the book id.
     * @return book id
     */
    int getId();

    /**
     * Set the book id.
     * @param id book id
     */
    void setId(int id);

    /**
     * Get the book title.
     * @return book title
     */
    String getTitle();

    /**
     * Set the book title.
     * @param title book title
     */
    void setTitle(String title);

    /**
     * Get book authors.
     * @return book authors
     */
    Collection<String> getAuthors();

    /**
     * Set book authors.
     * @param authors book authors
     */
    void setAuthors(Collection<String> authors);

    /**
     * Get book serial number.
     * @return number value
     */
    String getSerialNumber();

    /**
     * Set book serial number.
     * @param value number value
     */
    void setSerialNumber(String value);

    /**
     * Get return date for issued book.
     * @return return date
     */
    LocalDate getReturnDate();

    /**
     * Set return date for issued book.
     * @param date return date
     */
    void setReturnDate(LocalDate date);
}
