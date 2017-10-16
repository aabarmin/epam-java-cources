package com.epam.university.java.core.task034;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;


/**
 * Created by Вера on 15.10.2017.
 */
public class SaxHandlerImpl extends SaxHandler {

    private Node currentNode;
    private Node node = new Node("root");
    private LinkedList<Node> elements = new LinkedList<>();
    private List<PhoneNumber> phoneNumbers = new ArrayList<>();
    private String value;

    public Node getNode() {
        return this.node;
    }

    private Person personHandler = new PersonImpl();

    public Person getPersonHandler() {
        personHandler.setPhoneNumbers(phoneNumbers);
        return personHandler;
    }

    @Override
    public void startDocument() throws SAXException {
        this.personHandler = new PersonImpl();
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) throws SAXException {
        currentNode = new Node(qName);
        this.elements.addLast(currentNode);
        //System.out.println("start " + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            currentNode.addAttribute(
                    attributes.getQName(i),
                    attributes.getValue(i)
            );
        }


    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = new String(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("End " + qName);
        if (qName.equals(currentNode.getName())) {
            currentNode.setValue(value);
        }
        //
        final Node lastNode = this.elements.removeLast();
        //
        if (!elements.isEmpty()) {
            this.elements.getLast().addChild(lastNode);
        }
    }


    class Node {
        private final Map<String, String> attributes = new HashMap<>();
        private final Collection<Node> children = new ArrayList<>();
        private final String name;
        private String value;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setValue(String value) {
            this.value = value;
            if (name.equals("first-name")) {
                personHandler.setFirstName(value);
                //System.out.println("person set first-name");
            }
            if (name.equals("last-name")) {
                personHandler.setLastName(value);
            }
            if (name.equals("person-phone")) {
                PhoneNumberImpl phoneNumber = new PhoneNumberImpl();
                phoneNumber.setPhoneNumber(value);
                phoneNumbers.add(phoneNumber);
            }
        }

        public void addAttribute(String name, String value) {
            this.attributes.put(name, value);
            if (name.equals("id")) {
                personHandler.setId(Integer.parseInt(value));
            }
        }

        public void addChild(Node child) {
            this.children.add(child);
        }
    }
}