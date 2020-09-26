package com.epam.university.java.project.core.state.machine.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Romin Nuro on 26.09.2020 22:40.
 */
@XmlRootElement(name = "transition")
public class StateMachineStateImpl<TYPE, EVENT> implements StateMachineState<TYPE, EVENT> {
    @XmlAttribute
    private TYPE from;
    @XmlAttribute
    private TYPE to;
    @XmlAttribute
    private EVENT on;
    @XmlAttribute
    private String call;

    /**
     * From state.
     *
     * @return state name
     */
    @Override
    public TYPE getFrom() {
        return null;
    }

    /**
     * Set from state.
     *
     * @param state state name
     */
    @Override
    public void setFrom(TYPE state) {

    }

    /**
     * Get to state.
     *
     * @return state name
     */
    @Override
    public TYPE getTo() {
        return null;
    }

    /**
     * Set to state.
     *
     * @param state state name
     */
    @Override
    public void setTo(TYPE state) {

    }

    /**
     * Get event.
     *
     * @return event name
     */
    @Override
    public EVENT getOn() {
        return null;
    }

    /**
     * Set event name.
     *
     * @param event event name
     */
    @Override
    public void setOn(EVENT event) {

    }

    /**
     * Get method name to call on event. Method should exists in event handler.
     *
     * @return method name
     */
    @Override
    public String getMethodToCall() {
        return null;
    }

    /**
     * Set method name to call on event.
     *
     * @param method method name
     */
    @Override
    public void setMethodToCall(String method) {

    }
}
