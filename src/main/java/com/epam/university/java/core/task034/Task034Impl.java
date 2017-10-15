package com.epam.university.java.core.task034;

import com.epam.university.java.core.task034.jaxbImpl.PersonJaxb;
import com.epam.university.java.core.task034.jaxbImpl.PhoneNumberJaxb;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Created by Александр on 13.10.2017.
 */
public class Task034Impl implements Task034 {
    /**
     * Parse XML document with SAX parser.
     *
     * @param handler  sax handler
     * @param filepath path to file with xml
     * @return parsed data
     */
    @Override
    public Person readWithSaxParser(DefaultHandler handler, String filepath) {
        SaxHandlerImpl saxp = (SaxHandlerImpl) handler;

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(getClass().getResourceAsStream(filepath), saxp);

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return saxp.getPerson();
    }

    /**
     * Parse XML document with JAXB parser.
     *
     * @param filepath path to file with xml
     * @return parsed data
     */
    @Override
    public Person readWithJaxbParser(String filepath) {

        try {
            JAXBContext context = JAXBContext.newInstance(
                    PersonJaxb.class,
                    PhoneNumberJaxb.class
            );
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (PersonJaxb) unmarshaller.unmarshal(
                    getClass().getResourceAsStream(filepath)
            );

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Parse document with StAX parser.
     *
     * @param streamReader stax reader
     * @return parsed data
     */
    @Override
    public Person readWithStaxParser(XMLStreamReader streamReader) {
        Person person = new PersonImpl();

        try {
            while (streamReader.hasNext()) {
                final int next = streamReader.next();
                if(XMLStreamConstants.START_ELEMENT == next){
                    if (streamReader.getName().toString() == "person") {
                        person.setId(Integer.valueOf(streamReader.getAttributeValue(0)));
                    } else if (streamReader.getName().toString() == "first-name") {
                        person.setFirstName(streamReader.getElementText());
                    } else if (streamReader.getName().toString() == "last-name") {
                        person.setLastName(streamReader.getElementText());
                    } else if (streamReader.getName().toString() == "person-phones") {
                        person.setPhoneNumbers(new ArrayList<PhoneNumber>());
                    } else if (streamReader.getName().toString() == "person-phone") {
                        person.getPhoneNumbers().add(
                                new PhoneNumberImpl(streamReader.getElementText()));
                    }
                } else if (XMLStreamConstants.END_ELEMENT == next) {
                    if (streamReader.getName().toString() == "person") {
                        return person;
                    }
                }

            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }

        return null;
    }
}
