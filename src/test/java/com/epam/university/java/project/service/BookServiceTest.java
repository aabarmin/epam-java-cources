package com.epam.university.java.project.service;

import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.project.core.cdi.context.ApplicationContext;
import com.epam.university.java.project.core.cdi.context.ApplicationContextFactory;
import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookStatus;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Book service test.
 */
public class BookServiceTest {
    private ApplicationContext applicationContext;
    private ApplicationContextFactory contextFactory;

    @Before
    public void setUp() throws Exception {
        contextFactory = TestHelper.getInstance(ApplicationContextFactory.class);
        applicationContext = contextFactory.newInstance();
    }

    @Test
    public void getServiceFromContext() throws Exception {
        final String contextPath = getClass().getResource("/project/library001.xml").getFile();
        applicationContext.loadBeanDefinitions(new XmlResource(contextPath));
        // get service from context by interface
        final BookService bookService = applicationContext.getBean(BookService.class);
        assertNotNull("Can't get book service from context", bookService);
    }

    @Test
    public void createNewBook() throws Exception {
        final String contextPath = getClass().getResource("/project/library001.xml").getFile();
        applicationContext.loadBeanDefinitions(new XmlResource(contextPath));
        // create new book instance
        final BookService bookService = applicationContext.getBean(BookService.class);
        final Book book = bookService.createBook();
        assertNotNull("Book service can't create book", book);
    }

    @Test
    public void checkBookOperations() throws Exception {
        final String contextPath = getClass().getResource("/project/library001.xml").getFile();
        applicationContext.loadBeanDefinitions(new XmlResource(contextPath));
        // create new book instance
        final BookService bookService = applicationContext.getBean(BookService.class);
        final Book newBook = bookService.createBook();
        newBook.setTitle("Demo book");
        newBook.setAuthors(Arrays.asList("Author 1", "Author 2"));
        final Book savedBook = bookService.save(newBook);
        assertTrue("Saved book have no id", savedBook.getId() > 0);
        // get book by id
        final Book bookById = bookService.getBook(savedBook.getId());
        assertNotNull("Can't get saved book by id", bookById);
        // get all books
        final Collection<Book> booksCollection = bookService.getBooks();
        assertNotNull("Can't get books collection", booksCollection);
        assertFalse("Books collection is empty", booksCollection.isEmpty());
        assertTrue("Books collection doesn't contains newly create book",
                booksCollection.contains(bookById));
        // remove book with service
        bookService.remove(bookById);
        assertNull("Book not removed", bookService.getBook(bookById.getId()));
        assertFalse("Book not remove", bookService.getBooks().contains(bookById));
    }

    @Test
    public void createNewBookInDraftStatus() throws Exception {
        final String contextPath = getClass().getResource("/project/library001.xml").getFile();
        applicationContext.loadBeanDefinitions(new XmlResource(contextPath));
        // create new book instance
        final BookService bookService = applicationContext.getBean(BookService.class);
        final Book book = bookService.createBook();
        // check book exists
        assertNotNull("Book was not created", book);
        // check book status
        assertEquals("Incorrect book status",
                BookStatus.DRAFT,
                book.getState()
        );
        // take book into the account
        final Book acceptedBook = bookService.accept(book, "12345");
        assertEquals("Incorrect book status",
                BookStatus.ACCOUNTED,
                book.getState()
        );
        // issue book
        final Book issuedBook = bookService.issue(
            acceptedBook,
            LocalDate.now().plus(3, ChronoUnit.DAYS)
        );
        assertEquals("Incorrect book status",
                BookStatus.ISSUED,
                book.getState()
        );
        // return book
        final Book returnedBook = bookService.returnFromIssue(issuedBook);
        assertEquals("Incorrect book status",
                BookStatus.ACCOUNTED,
                book.getState()
        );
    }
}