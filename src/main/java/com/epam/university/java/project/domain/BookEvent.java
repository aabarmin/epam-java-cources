package com.epam.university.java.project.domain;

/**
 * Book events.
 */
public enum BookEvent {
    /**
     * Create new book.
     */
    CREATE,
    /**
     * Accept book into the account.
     */
    ACCEPT,
    /**
     * Issue book from library.
     */
    ISSUE,
    /**
     * Return book from issue.
     */
    RETURN
}
