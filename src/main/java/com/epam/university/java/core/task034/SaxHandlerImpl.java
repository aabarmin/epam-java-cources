package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.Collection;

/**
 * {@inheritDoc}
 */
public class SaxHandlerImpl extends SaxHandler {

    private Person person;
    private String element = "";
    private Collection<PhoneNumber> phones;

    /**
     * {@inheritDoc}
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "person":
                person = new PersonImpl();
                String id = attributes.getValue("id");
                person.setId(Integer.parseInt(id));
                break;
            case "person-phones":
                phones = new ArrayList<>();
                person.setPhoneNumbers(phones);
                break;
            default:
                this.element = qName;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.element = "";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        switch (this.element) {
            case "first-name":
                person.setFirstName(new String(ch, start, length));
                break;
            case "last-name":
                person.setLastName(new String(ch, start, length));
                break;
            case "person-phone":
                PhoneNumber number = new PhoneNumberImpl();
                number.setPhoneNumber(new String(ch, start, length));
                person.getPhoneNumbers().add(number);
                break;
            default:
                break;
        }
    }

    @Override
    public void endDocument() throws SAXException {
        this.person.setPhoneNumbers(this.phones);
    }

    /**
     * Return person designed by parser.
     *
     * @return person
     */
    public Person getPerson() {
        return person;
    }
}
