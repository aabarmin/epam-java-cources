package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romin Nuro on 28.08.2020 13:59.
 */
public class SaxHandlerImpl extends SaxHandler {
    private Person person;
    private String currentElement;
    private final List<PhoneNumber> phoneNumbers = new ArrayList<>();

    @Override
    public void startDocument() throws SAXException {
        person = new PersonImpl();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equals("person")) {
            person.setId(Integer.parseInt(attributes.getValue("id")));
        }
        currentElement = qName;
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = String.copyValueOf(ch, start, length);

        switch (currentElement) {
            case ("first-name"): {
                person.setFirstName(value);
                break;
            }
            case ("last-name"): {
                person.setLastName(value);
                break;
            }
            case ("person-phone"): {
                phoneNumbers.add(new PhoneNumberImpl(value));
                break;
            }
            default: {
                return;
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("person-phones")) {
            person.setPhoneNumbers(phoneNumbers);
        }
        currentElement = "";
    }

    public Person getPerson() {
        return person;
    }
}
