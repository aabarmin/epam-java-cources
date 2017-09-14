package com.epam.university.java.project.domain;

import java.util.Collection;

/**
 * Book domain object interface.
 */
public interface Book {
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
}
