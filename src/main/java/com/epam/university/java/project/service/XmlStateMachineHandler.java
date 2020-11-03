package com.epam.university.java.project.service;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinitionImpl;
import com.epam.university.java.project.core.state.machine.domain.StateMachineStateImpl;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;
import com.sun.jdi.event.ThreadStartEvent;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlStateMachineHandler extends DefaultHandler {
    StateMachineDefinitionImpl stateMachineDefinition;
    StateMachineStateImpl stateMachineState;
    String from;
    String to;
    String on;
    String call;
    boolean bTransition = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {


        if (qName.equalsIgnoreCase("definition")) {
            stateMachineDefinition = new StateMachineDefinitionImpl();
            String startEvent = attributes.getValue("startEvent");
            String startState = attributes.getValue("startState");
            stateMachineDefinition.setStartState(BookStatus.valueOf(startState));
            stateMachineDefinition.setStartEvent(BookEvent.valueOf(startEvent));
        } else if (qName.equalsIgnoreCase("transition")) {
            from = attributes.getValue("from");
            to = attributes.getValue("to");
            on = attributes.getValue("on");
            call = attributes.getValue("call");
            bTransition = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if (bTransition) {
            stateMachineState = new StateMachineStateImpl(BookStatus.valueOf(from),
                    BookStatus.valueOf(to),
                    BookEvent.valueOf(on), call);
            stateMachineDefinition.addState(stateMachineState);
            bTransition = false;
        }
    }

    public StateMachineDefinitionImpl getStateMachineDefinition() {
        return this.stateMachineDefinition;
    }


}