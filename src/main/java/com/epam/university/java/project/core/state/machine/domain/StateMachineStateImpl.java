package com.epam.university.java.project.core.state.machine.domain;

public class StateMachineStateImpl<TYPE, EVENT> implements StateMachineState<TYPE, EVENT> {
    @Override
    public TYPE getFrom() {
        return null;
    }

    @Override
    public void setFrom(TYPE state) {

    }

    @Override
    public TYPE getTo() {
        return null;
    }

    @Override
    public void setTo(TYPE state) {

    }

    @Override
    public EVENT getOn() {
        return null;
    }

    @Override
    public void setOn(EVENT event) {

    }

    @Override
    public String getMethodToCall() {
        return null;
    }

    @Override
    public void setMethodToCall(String method) {

    }
}
