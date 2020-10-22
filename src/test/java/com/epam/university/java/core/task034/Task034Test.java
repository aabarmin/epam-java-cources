package com.epam.university.java.core.task034;

import com.epam.university.java.core.helper.TestHelper;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class Task034Test {
    private Task034 instance;
    private SaxHandler saxHandler;

    @Before
    public void setUp() throws Exception {
        instance = TestHelper.getInstance(Task034.class);
        saxHandler = TestHelper.getInstance(SaxHandler.class);
    }

    @Test
    public void readWithSaxParser() throws Exception {
        final Person person = instance.readWithSaxParser(
                saxHandler,
                "A:\\epam-java-cources\\src\\main\\resources\\task034\\data.xml"
        );
        assertNotNull("XML was not parsed", person);
        assertEquals("Incorrect XML parsing",
                10,
                person.getId()
        );
        assertEquals("Incorrect XML parsing",
                "Ivan",
                person.getFirstName()
        );
        assertEquals("Incorrect XML parsing",
                "Petrov",
                person.getLastName()
        );
        assertNotNull("Incorrect XML parsing", person.getPhoneNumbers());
        assertEquals("Incorrect XML parsing",
                2,
                person.getPhoneNumbers().size()
        );
        assertArrayEquals("Incorrect XML parsing",
                new String[]{"Phone first", "Phone second"},
                person.getPhoneNumbers()
                        .stream()
                        .map(PhoneNumber::getPhoneNumber)
                        .toArray()
        );
    }

    @Test
    public void readWithJaxParser() throws Exception {
        final Person person = instance.readWithJaxbParser("A:\\epam-java-cources\\src\\main"
                + "\\resources\\task034\\data.xml");
        assertNotNull("XML was not parsed", person);
        assertEquals("Incorrect XML parsing",
                10,
                person.getId()
        );
        assertEquals("Incorrect XML parsing",
                "Ivan",
                person.getFirstName()
        );
        assertEquals("Incorrect XML parsing",
                "Petrov",
                person.getLastName()
        );
        assertNotNull("Incorrect XML parsing", person.getPhoneNumbers());
        assertEquals("Incorrect XML parsing",
                2,
                person.getPhoneNumbers().size()
        );
        assertArrayEquals("Incorrect XML parsing",
                new String[]{"Phone first", "Phone second"},
                person.getPhoneNumbers()
                        .stream()
                        .map(PhoneNumber::getPhoneNumber)
                        .toArray()
        );
    }

    @Test
    public void readWithStaxParser() throws Exception {
        final InputStream inputStream = getClass().getResourceAsStream("/task034/data.xml");
        final XMLStreamReader streamReader = XMLInputFactory.newFactory()
                .createXMLStreamReader(inputStream);
        final Person person = instance.readWithStaxParser(streamReader);
        assertNotNull("XML was not parsed", person);
        assertEquals("Incorrect XML parsing",
                10,
                person.getId()
        );
        assertEquals("Incorrect XML parsing",
                "Ivan",
                person.getFirstName()
        );
        assertEquals("Incorrect XML parsing",
                "Petrov",
                person.getLastName()
        );
        assertNotNull("Incorrect XML parsing", person.getPhoneNumbers());
        assertEquals("Incorrect XML parsing",
                2,
                person.getPhoneNumbers().size()
        );
        assertArrayEquals("Incorrect XML parsing",
                new String[]{"Phone first", "Phone second"},
                person.getPhoneNumbers()
                        .stream()
                        .map(PhoneNumber::getPhoneNumber)
                        .toArray()
        );
    }
}