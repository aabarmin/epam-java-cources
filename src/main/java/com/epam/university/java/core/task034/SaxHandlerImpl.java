package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Collection;

public class SaxHandlerImpl extends SaxHandler {
    private Person person;
    private Collection<PhoneNumber> phones = new ArrayList<>();
    private String currentNode;

    @Override
    public void startDocument() throws SAXException {
        person = new PersonImpl();
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        if ("person".equals(qName)) {
            person.setId(Integer.valueOf(attributes.getValue("id")));
        }
        currentNode = qName;
    }

    @Override
    public void endDocument() throws SAXException {
        person.setPhoneNumbers(phones);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (null == person || null == currentNode) {
            return;
        }
        String value = new String(ch, start, length);
        switch (currentNode) {
            case "first-name":
                person.setFirstName(value);
                currentNode = null;
                break;
            case "last-name":
                person.setLastName(value);
                currentNode = null;
                break;
            case "person-phone":
                phones.add(new PhoneNumberImpl(value));
                currentNode = null;
                break;
            default:
                break;
        }

    }

    public Person getPerson() {
        return person;
    }
}
