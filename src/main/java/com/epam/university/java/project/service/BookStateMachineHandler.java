package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StateMachineStateImpl;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BookStateMachineHandler extends DefaultHandler {
    StateMachineDefinitionImpl stateMachineDefinition;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        StateMachineStateImpl stateMachineState;

        if (qName.equalsIgnoreCase("definition")) {
            String startEvent = attributes.getValue("startEvent");
            String startState = attributes.getValue("startState");
            stateMachineState = new StateMachineStateImpl(null,
                    BookStatus.valueOf(startEvent),
                    BookEvent.valueOf(startState));
            stateMachineDefinition.addState(stateMachineState);
        }

        else if (qName.equalsIgnoreCase("transition")){
            String from = attributes.getValue("from");
            String to = attributes.getValue("to");
            String on = attributes.getValue("on");
            String call = attributes.getValue("call");
            stateMachineState = new StateMachineStateImpl(BookStatus.valueOf(from), BookStatus.valueOf(to),
                    BookEvent.valueOf(on), call);
            stateMachineDefinition.addState(stateMachineState);
        }
    }

    public StateMachineDefinitionImpl getStateMachineDefinition() {
        return this.stateMachineDefinition;
    }
}
