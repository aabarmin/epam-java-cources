package com.epam.university.java.core.task034;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Implementation class for Task034.
 *
 * @author Sergei Titov
 */
public class Task034Impl implements Task034 {

    // possible nodes
    protected enum Nodes {
        person,
        first_name,
        last_name,
        person_phone,
        person_phones;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filePath) {

        final SAXParserFactory factory = SAXParserFactory.newInstance();
        final SAXParser parser;
        try {
            parser = factory.newSAXParser();
            InputSource source = new InputSource(
                    getClass().getResourceAsStream(filePath)
            );

            parser.parse(
                    source,
                    handler
            );

            return ((SaxHandlerImpl)handler).getPerson();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Person readWithJaxbParser(String filePath) {

        final JAXBContext context;
        try {
            context = JAXBContext.newInstance(
                    PersonImpl.class,
                    PhoneNumberImpl.class
                    );

        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }
        final Unmarshaller unmarshaller;
        try {
            unmarshaller = context.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
            return null;
        }

        try (InputStream inputStream = getClass().getResourceAsStream(filePath)) {
            final PersonImpl person = (PersonImpl) unmarshaller.unmarshal(
                    inputStream
            );
            return person;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Person readWithStaxParser(XMLStreamReader reader) {

        PersonImpl person = new PersonImpl();
        Nodes currentNode = null;

        try {
            while (reader.hasNext()) {
                final int next = reader.next();

                // START_ELEMENT
                if (XMLStreamConstants.START_ELEMENT == next) {

                    // new NODE started
                    currentNode = Nodes.valueOf(
                            reader.getName().toString().replaceAll("-", "_"));

                    if (Nodes.person == currentNode) {
                        // person (with id)
                        person = new PersonImpl();
                        person.setId(Integer.valueOf(reader.getAttributeValue(0)));
                    } else if (Nodes.person_phones == currentNode) {
                        // PhoneNumbers
                        person.setPhoneNumbers(new ArrayList<>());
                    }

                // END_ELEMENT
                } else if (XMLStreamConstants.END_ELEMENT == next) {
                    currentNode = null;

                // CHARACTERS
                } else if (XMLStreamConstants.CHARACTERS == next) {

                    if (null == currentNode) {
                        continue;
                    }
                    String value = reader.getText();

                    switch (currentNode) {

                        case first_name: {
                            person.setFirstName(value);
                            break;
                        }

                        case last_name: {
                            person.setLastName(value);
                            break;
                        }

                        case person_phone: {
                            person.getPhoneNumbers().add(new PhoneNumberImpl(value));
                            break;
                        }

                        default: {
                            break;
                        }
                    }
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return person;
    }
}
