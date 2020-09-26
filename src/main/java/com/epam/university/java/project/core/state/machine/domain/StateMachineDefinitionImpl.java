package com.epam.university.java.project.core.state.machine.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Collection;

/**
 * Created by Romin Nuro on 26.09.2020 22:34.
 */
@XmlRootElement(name = "definition")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateMachineDefinitionImpl<STATE, EVENT> implements StateMachineDefinition<STATE, EVENT> {
    @XmlAttribute(name = "startEvent")
    private EVENT startEvent;
    @XmlAttribute(name = "startState")
    private STATE startState;
    @XmlElement(name = "transition", type = StateMachineStateImpl.class)
    private Collection<StateMachineState<STATE, EVENT>> states;
    @XmlAttribute(name = "handlerClass")
    @XmlJavaTypeAdapter(HandlerClassAdapter.class)
    private Class<? extends StateMachineEventHandler> handlerClass;
    /**
     * Get start event.
     *
     * @return event name
     */
    @Override
    public EVENT getStartEvent() {
        return startEvent;
    }

    /**
     * Get start state.
     *
     * @return state name
     */
    @Override
    public STATE getStartState() {
        return startState;
    }

    /**
     * Set start event.
     *
     * @param event event name
     */
    @Override
    public void setStartEvent(EVENT event) {
        this.startEvent = event;
    }

    /**
     * Set start state.
     *
     * @param state state name
     */
    @Override
    public void setStartState(STATE state) {
        this.startState = state;
    }

    /**
     * Get state machine states collection.
     *
     * @return states
     */
    @Override
    public Collection<StateMachineState<STATE, EVENT>> getStates() {
        return states;
    }

    /**
     * Add state to state machine definition.
     *
     * @param state state to add
     */
    @Override
    public void addState(StateMachineState<STATE, EVENT> state) {
        states.add(state);
    }

    /**
     * Get state machine handler class.
     *
     * @return handler class
     */
    @Override
    public Class<? extends StateMachineEventHandler> getHandlerClass() {
        return handlerClass;
    }

    /**
     * Set state machine handler class.
     *
     * @param handlerClass handler class
     */
    @Override
    public void setHandlerClass(Class<? extends StateMachineEventHandler> handlerClass) {
        this.handlerClass = handlerClass;
    }
}
