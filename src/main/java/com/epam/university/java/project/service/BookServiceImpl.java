package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;

import java.time.LocalDate;
import java.util.Collection;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private StateMachineManager stateMachineManager;
    private XmlResource xmlResource;

    /**
     * Constructor of BookServiceImpl.
     */
    public BookServiceImpl() {
        xmlResource = new XmlResource(
                getClass().getResource("/project/DefaultBookStateMachineDefinition.xml").getFile()
        );
    }

    /**
     * Create new draft book instance.
     *
     * @return new book instance
     */
    @Override
    @SuppressWarnings("unchecked")
    public Book createBook() {
        StateMachineDefinition stateMachineDefinition =
                stateMachineManager.loadDefinition(xmlResource);
        StatefulEntity statefulEntity =
                stateMachineManager.initStateMachine(bookDao.createBook(), stateMachineDefinition);

        return (Book) stateMachineManager.handleEvent(statefulEntity, BookEvent.CREATE);
    }

    /**
     * Get the book by id.
     *
     * @param id book id
     * @return book instance
     */
    @Override
    public Book getBook(int id) {
        return bookDao.getBook(id);
    }

    /**
     * Get all books.
     *
     * @return books collection
     */
    @Override
    public Collection<Book> getBooks() {
        return bookDao.getBooks();
    }

    /**
     * Remove book from library.
     *
     * @param book book to remove
     */
    @Override
    public void remove(Book book) {
        bookDao.remove(book);
    }

    /**
     * Save book to library.
     *
     * @param book book to save
     * @return saved book instance
     */
    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    /**
     * Accept book into the account with the following <code>number</code>.
     *
     * @param book   book to accept
     * @param number book number
     * @return accounted book
     */
    @Override
    public Book accept(Book book, String number) {
        book.setSerialNumber(number);
        return (Book) stateMachineManager.handleEvent(book, BookEvent.ACCEPT);
    }

    /**
     * Issue book and set return date.
     *
     * @param book       book to issue
     * @param returnDate return date
     * @return issued book
     */
    @Override
    public Book issue(Book book, LocalDate returnDate) {
        book.setReturnDate(returnDate);
        return (Book) stateMachineManager.handleEvent(book, BookEvent.ISSUE);
    }

    /**
     * Return book from issue.
     *
     * @param book book to return
     * @return accounted book
     */
    @Override
    public Book returnFromIssue(Book book) {
        book.setReturnDate(null);
        return (Book) stateMachineManager.handleEvent(book, BookEvent.RETURN);
    }

    //for correct dependencies injection

    /**
     * Get BookDao.
     *
     * @return BookDao
     */
    public BookDao getBookDao() {
        return bookDao;
    }

    /**
     * Set BookDao.
     *
     * @param bookDao bookDao
     */
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    /**
     * Get StateMachineManager.
     *
     * @return StateMachineManage
     */
    public StateMachineManager getStateMachineManager() {
        return stateMachineManager;
    }

    /**
     * Set StateMachineManager.
     *
     * @param stateMachineManager stateMachineManage
     */
    public void setStateMachineManager(StateMachineManager stateMachineManager) {
        this.stateMachineManager = stateMachineManager;
    }
}
