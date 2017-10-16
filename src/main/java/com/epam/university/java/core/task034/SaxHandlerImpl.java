package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SaxHandlerImpl extends SaxHandler {

    private Person person;
    private Collection<PhoneNumber> phoneNumbers;
    private String value;

    public Person getPerson() {
        return person;
    }

    @Override
    public void startDocument() throws SAXException {
        this.person = new PersonImpl();
    }


    @Override
    public void startElement(String uri,
                             String localName,
                             String qName,
                             Attributes attributes) throws SAXException {
        switch (qName) {
            case "person": {
                person.setId(Integer.parseInt(attributes.getValue("id")));
                break;
            }
            case "person-phones": {
                phoneNumbers = new ArrayList<>();
                break;
            }
            default: {
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        person.addElement(qName, value);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = String.copyValueOf(ch, start, length);
    }


}


