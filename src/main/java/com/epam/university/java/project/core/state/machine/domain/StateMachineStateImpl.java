package com.epam.university.java.project.core.state.machine.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Implementation class for StateMachineDefinition.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "transition")
public class StateMachineStateImpl implements StateMachineState {

    private Object from;
    private Object to;
    private Object on;
    private String call;

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getFrom() {
        return from;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFrom(Object state) {
        this.from = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getTo() {
        return to;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTo(Object state) {
        this.to = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getOn() {
        return on;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOn(Object o) {
        this.on = o;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMethodToCall() {
        return call;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMethodToCall(String method) {
        this.call = method;
    }
}
