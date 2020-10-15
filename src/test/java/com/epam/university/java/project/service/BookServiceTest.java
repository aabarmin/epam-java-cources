package com.epam.university.java.project.service;

import com.epam.university.java.core.helper.ReflectionUtils;
import com.epam.university.java.core.helper.TestHelper;
import com.epam.university.java.project.core.cdi.context.ApplicationContext;
import com.epam.university.java.project.core.cdi.context.ApplicationContextFactory;
import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.domain.StatefulEntity;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookStatus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
    @SuppressWarnings("unchecked")
    public void createNewBookInDraftStatus() throws Exception {
        final String contextPath = getClass().getResource("/project/library001.xml").getFile();
        applicationContext.loadBeanDefinitions(new XmlResource(contextPath));
        // create new book instance
        final BookService bookService = applicationContext.getBean(BookService.class);
        final StateMachineManager stateMachineManager = Mockito.spy(
                applicationContext.getBean(StateMachineManager.class)
        );
        ReflectionUtils.setField(bookService, "stateMachineManager", stateMachineManager);
        //
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
        // invocation checks
        verify(stateMachineManager, times(1)).loadDefinition(any(Resource.class));
        verify(stateMachineManager, atLeast(4)).handleEvent(
                any(StatefulEntity.class),
                anyObject()
        );
        verify(stateMachineManager, times(1)).initStateMachine(
                any(StatefulEntity.class),
                any(StateMachineDefinition.class)
        );
    }

    @Test
    @SuppressWarnings("unchecked")
    public void persistStateBetweenLoads() throws Exception {
        final String contextPath = getClass().getResource("/project/library001.xml").getFile();
        applicationContext.loadBeanDefinitions(new XmlResource(contextPath));
        // create new book instance
        final BookService bookService = applicationContext.getBean(BookService.class);
        final StateMachineManager stateMachineManager = Mockito.spy(
                applicationContext.getBean(StateMachineManager.class)
        );
        ReflectionUtils.setField(bookService, "stateMachineManager", stateMachineManager);
        //
        final Book book = bookService.createBook();
        // check book exists
        assertNotNull("Book was not created", book);
        // check book status
        assertEquals("Incorrect book status",
                BookStatus.DRAFT,
                book.getState()
        );
        // save book back
        final Book savedDraftBook = bookService.save(book);
        // load book back
        final Book loadedDraftBook = bookService.getBook(savedDraftBook.getId());
        assertEquals("Incorrect book status",
                BookStatus.DRAFT,
                loadedDraftBook.getState()
        );
        // take book into the account
        final Book acceptedBook = bookService.accept(loadedDraftBook, "12345");
        assertEquals("Incorrect book status",
                BookStatus.ACCOUNTED,
                acceptedBook.getState()
        );
        final Book savedAcceptedBook = bookService.save(acceptedBook);
        // load book back
        final Book loadedAcceptedBook = bookService.getBook(savedAcceptedBook.getId());
        assertEquals("Incorrect book status",
                BookStatus.ACCOUNTED,
                loadedAcceptedBook.getState()
        );
        // issue book
        final Book issuedBook = bookService.issue(
                loadedAcceptedBook,
                LocalDate.now().plus(3, ChronoUnit.DAYS)
        );
        assertEquals("Incorrect book status",
                BookStatus.ISSUED,
                issuedBook.getState()
        );
        final Book savedIssuedBook = bookService.save(issuedBook);
        // load book back
        final Book loadedIssuedBook = bookService.getBook(savedIssuedBook.getId());
        assertEquals("Incorrect book status",
                BookStatus.ISSUED,
                loadedIssuedBook.getState()
        );
        // return book
        final Book returnedBook = bookService.returnFromIssue(loadedIssuedBook);
        assertEquals("Incorrect book status",
                BookStatus.ACCOUNTED,
                returnedBook.getState()
        );
        final Book savedReturnedBook = bookService.save(returnedBook);
        final Book loadedReturnedBook = bookService.getBook(savedReturnedBook.getId());
        assertEquals("Incorrect book status",
                BookStatus.ACCOUNTED,
                loadedReturnedBook.getState()
        );
        // invocation checks
        verify(stateMachineManager, times(1)).loadDefinition(any(Resource.class));
        verify(stateMachineManager, atLeast(4)).handleEvent(
                any(StatefulEntity.class),
                anyObject()
        );
        verify(stateMachineManager, times(1)).initStateMachine(
                any(StatefulEntity.class),
                any(StateMachineDefinition.class)
        );
    }

    @Test
    public void createTwoBooks() {
        final String contextPath = getClass().getResource("/project/library001.xml").getFile();
        applicationContext.loadBeanDefinitions(new XmlResource(contextPath));
        // create new book instances
        final BookService bookService = applicationContext.getBean(BookService.class);
        final Book book1 = bookService.createBook();
        book1.setTitle("Demo book 1");
        book1.setAuthors(Arrays.asList("Author 1", "Author 2"));
        final Book book2 = bookService.createBook();
        book2.setTitle("Demo book 2");
        book2.setAuthors(Arrays.asList("Author 3", "Author 4", "Author 5"));
        // accept books and check serial numbers
        Book acceptedBook1 = bookService.accept(book1, "12345");
        Book acceptedBook2 = bookService.accept(book2, "12346");
        assertEquals("First book serial number is incorrect",
                "12345",
                acceptedBook1.getSerialNumber()
        );
        assertEquals("Second book serial number is incorrect",
                "12346",
                acceptedBook2.getSerialNumber()
        );
        // save books and check identifiers
        Book savedBook1 = bookService.save(acceptedBook1);
        Book savedBook2 = bookService.save(acceptedBook2);
        assertNotEquals("First book id equals second book id",
                savedBook1.getId(),
                savedBook2.getId()
        );
    }
}