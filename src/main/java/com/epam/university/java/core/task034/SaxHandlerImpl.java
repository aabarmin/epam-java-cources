package com.epam.university.java.core.task034;

import com.epam.university.java.core.utils.common.Validator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Class implements SaxHandler.
 */
public class SaxHandlerImpl extends SaxHandler {
    private Person person = null;
    private PhoneNumber phoneNumber = null;
    private boolean isFirstName = false;
    private boolean isLastName = false;
    private boolean isPhoneNumber = false;

    /**
     * Get <code>Person</code>.
     *
     * @return <code>Person</code>
     */
    public Person getPerson() {
        return person;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        Validator.validateNotNull(uri, Validator.MESSAGE_FOR_SOURCE_IF_NULL);
        if (qName.equalsIgnoreCase("person")) {
            String id = attributes.getValue("id");
            person = new PersonImpl();
            person.setId(Integer.parseInt(id));
            System.out.println(person);
        } else if (qName.equalsIgnoreCase("first-name")) {
            isFirstName = true;
            System.out.println("first true");
        } else if (qName.equalsIgnoreCase("last-name")) {
            isLastName = true;
            System.out.println("last true");
        } else if (qName.equalsIgnoreCase("person-phone")) {
            phoneNumber = new PhoneNumberImpl();
            isPhoneNumber = true;
            System.out.println("phone true");
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws
            SAXException {
        if (isFirstName) {
            person.setFirstName(new String(ch, start, length));
            isFirstName = false;
            System.out.println(person);
        } else if (isLastName) {
            person.setLastName(new String(ch, start, length));
            isLastName = false;
            System.out.println(person);
        } else if (isPhoneNumber) {
            phoneNumber.setPhoneNumber(new String(ch, start, length));
            person.getPhoneNumbers().add(phoneNumber);
            isPhoneNumber = false;
            System.out.println(person);
        }
    }
}