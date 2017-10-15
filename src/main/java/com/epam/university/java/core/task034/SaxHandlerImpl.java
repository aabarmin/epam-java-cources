package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;

/**
 * Implementation class for Task034.
 *
 * @author Sergei Titov
 */
public class SaxHandlerImpl extends SaxHandler {

    private PersonImpl person;
    private Task034Impl.Nodes currentNode;


    /**
     * {@inheritDoc}
     */
    @Override
    public void startElement(String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException {

        currentNode = Task034Impl.Nodes.valueOf(qName.replaceAll("-", "_"));

        if (Task034Impl.Nodes.person == currentNode) {
            person = new PersonImpl();
            person.setId(Integer.valueOf(attributes.getValue("id")));
        } else if (Task034Impl.Nodes.person_phones == currentNode) {
            person.setPhoneNumbers(new ArrayList<>());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (null == person || null == currentNode) {
            return;
        }

        String value = new String(ch, start, length);

        switch (currentNode) {

            case first_name: {
                person.setFirstName(value);
                currentNode = null;
                break;
            }

            case last_name: {
                person.setLastName(value);
                currentNode = null;
                break;
            }

            case person_phone: {
                person.getPhoneNumbers().add(new PhoneNumberImpl(value));
                currentNode = null;
                break;
            }

            default: {
                break;
            }
        }

    }


    /**
     * Gets person.
     *
     * @return composed person object
     */
    public PersonImpl getPerson() {

        return person;
    }
}
