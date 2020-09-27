package com.epam.university.java.core.task034;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Author Dmitry Novikov 15-Sep-20.
 */
public class SaxHandlerImpl extends SaxHandler {
    private Person person;
    private String thisElement;
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();

    public Person getResult() {
        return person;
    }

    @Override
    public void startDocument() throws SAXException {
        person = new PersonImpl();
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        if (qName.equals("person")) {
            person.setId(Integer.parseInt(attributes.getValue("id")));
        }
        thisElement = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("first-name")) {
            person.setFirstName(new String(ch, start, length));
        }
        if (thisElement.equals("last-name")) {
            person.setLastName(new String(ch, start, length));
        }

        if (thisElement.equals("person-phone")) {
            phoneNumbers.add(new PhoneNumberImpl(new String(ch, start, length)));
        }
    }

    @Override
    public void endElement(String namespaceUri, String localName, String qName)
            throws SAXException {
        if (qName.equals("person-phones")) {
            person.setPhoneNumbers(phoneNumbers);
        }
        thisElement = "";
    }
}
