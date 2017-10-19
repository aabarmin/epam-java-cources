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
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вера on 15.10.2017.
 */
public class Task034Impl implements Task034 {
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        Person person = new PersonImpl();
        try {
            final SAXParserFactory factory = SAXParserFactory.newInstance();
            final SAXParser parser = factory.newSAXParser();
            SaxHandlerImpl saxHandler = (SaxHandlerImpl) handler;

            InputSource source = new InputSource(
                getClass().getResourceAsStream(filepath));

            parser.parse(source, saxHandler);

            person = saxHandler.getPersonHandler();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Person readWithJaxbParser(String filepath) {

        Person person = new PersonImpl();
        try {
            JAXBContext context = JAXBContext.newInstance(PersonImpl.class, PhoneNumberImpl.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            person = (Person) unmarshaller.unmarshal(getClass().getResourceAsStream(filepath));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Person person = new PersonImpl();
        List<PhoneNumber> phoneNumbers = new ArrayList<>();

        String name = "";

        final XMLInputFactory factory = XMLInputFactory.newFactory();
        final XMLStreamReader reader = streamReader;

        try {
            int event = reader.getEventType();
            while (true) {
                switch (event) {
                    case XMLStreamConstants.START_DOCUMENT:
                        break;
                    case XMLStreamConstants.START_ELEMENT:
                        name = String.valueOf(reader.getName());
                        if (reader.getAttributeCount() > 0) {
                            if (reader.getAttributeName(0).toString().equals("id")) {
                                person.setId(Integer.parseInt(reader.getAttributeValue(0)));
                            }
                        }
                        //for(int i = 0, n = reader.getAttributeCount(); i < n; ++i)
                        //reader.getAttributeName(i)
                        //person.setId(Integer.parseInt(reader.getAttributeValue(0)));
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if (reader.isWhiteSpace()) {
                            break;
                        }
                        if (name.equals("first-name")) {
                            person.setFirstName(reader.getText());
                        }
                        if (name.equals("last-name")) {
                            person.setLastName(reader.getText());
                        }
                        if (name.equals("person-phone")) {
                            PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
                            phoneNumber.setPhoneNumber(reader.getText());
                            phoneNumbers.add(phoneNumber);
                        }

                        //out.println("Text: " + reader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        //out.println("End Element:" + reader.getName());
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        //out.println("End Document.");
                        break;
                    default:
                        break;
                }

                if (!reader.hasNext()) {
                    break;
                }

                event = reader.next();
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }

        person.setPhoneNumbers(phoneNumbers);

        return person;
    }
}
