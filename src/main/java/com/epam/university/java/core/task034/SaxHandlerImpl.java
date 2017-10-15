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
    private Task034Impl.NODES current_node;


    /**
     * {@inheritDoc}
     */
    @Override
    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException
    {
        current_node = Task034Impl.NODES.valueOf(qName.replaceAll("-", "_"));

        if (Task034Impl.NODES.person == current_node) {
            person = new PersonImpl();
            person.setId(Integer.valueOf(attributes.getValue("id")));
        } else if (Task034Impl.NODES.person_phones == current_node) {
            person.setPhoneNumbers(new ArrayList<>());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        if (null == person || null == current_node) {
            return;
        }

        String value = new String(ch, start, length);

        switch (current_node) {

            case first_name: {
                person.setFirstName(value);
                current_node = null;
                break;
            }

            case last_name: {
                person.setLastName(value);
                current_node = null;
                break;
            }

            case person_phone: {
                person.getPhoneNumbers().add(new PhoneNumberImpl(value));
                current_node = null;
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
