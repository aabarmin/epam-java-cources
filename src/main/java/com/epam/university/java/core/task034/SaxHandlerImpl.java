package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;

public class SaxHandlerImpl extends SaxHandler {

    private String currentElement;
    private final Person person;
    private final ArrayList<PhoneNumber> phoneNumbers;

    /**
     * Sax handler default constructor.
     */
    public SaxHandlerImpl() {
        person = new PersonImpl();
        phoneNumbers = new ArrayList<>();
        person.setPhoneNumbers(phoneNumbers);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElement = qName;

        for (int i = 0; i < attributes.getLength(); i++) {
            if (attributes.getLocalName(i) == "id") {
                person.setId(Integer.parseInt(attributes.getValue(0)));
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String value = new String(ch, start, length);

        if (currentElement.equals("first-name")) {
            person.setFirstName(value);
        }
        if (currentElement.equals("last-name")) {
            person.setLastName(value);
        }
        if (currentElement.equals("person-phone")) {
            PhoneNumber phoneNumber = new PhoneNumberImpl();
            phoneNumber.setPhoneNumber(value);
            person.getPhoneNumbers().add(phoneNumber);
        }
    }

    public Person getPerson() {
        return person;
    }
}
