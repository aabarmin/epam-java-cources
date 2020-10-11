package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.LinkedList;
import java.util.List;

public class SaxHandlerImpl extends SaxHandler {
    private boolean isFirstName = false;
    private boolean isLastName = false;
    private boolean isPhoneNumber = false;

    private List<Person> persons = new LinkedList<>();
    private Person person;
    private List<PhoneNumber> phoneNumbers;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("person")) {
            person = new PersonImpl();
            String tempId = attributes.getValue("id");
            int id = Integer.parseInt(tempId);
            person.setId(id);
        }

        if (qName.equalsIgnoreCase("person-phones")) {
            phoneNumbers = new LinkedList<>();
        }

        isFirstName = qName.equalsIgnoreCase("first-Name");
        isLastName = qName.equalsIgnoreCase("last-Name");
        isPhoneNumber = qName.equalsIgnoreCase("person-phone");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length);
        if (isFirstName) {
            person.setFirstName(new String(ch, start, length));
            isFirstName = false;
        } else if (isLastName) {
            person.setLastName(new String(ch, start, length));
            isLastName = false;
        } else if (isPhoneNumber) {
            PhoneNumber phoneNumber = new PhoneNumberImpl();
            phoneNumber.setPhoneNumber(new String(ch, start, length));
            phoneNumbers.add(phoneNumber);
            isPhoneNumber = false;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("person-phones")) {
            person.setPhoneNumbers(phoneNumbers);
        }

        if (qName.equalsIgnoreCase("person")) {
            persons.add(person);
        }
    }

    public Person getPerson() {
        return this.persons.get(0);
    }
}
