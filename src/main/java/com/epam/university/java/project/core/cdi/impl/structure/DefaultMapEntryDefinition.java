package com.epam.university.java.project.core.cdi.impl.structure;

import com.epam.university.java.project.core.cdi.structure.MapDefinition;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Default definition of map entry.
 */
@XmlRootElement(name = "entry")
public class DefaultMapEntryDefinition implements MapDefinition.MapEntryDefinition {

    private String key;
    private String value;
    private String ref;

    /**
     * Get map entry key.
     * @return entry key
     */
    @Override
    public String getKey() {
        return key;
    }

    /**
     * Set map entry key.
     * @param key entry key
     */
    @Override
    @XmlElement(name = "key")
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get map entry value.
     * @return entry value
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Set map entry value.
     * @param value entry value
     */
    @Override
    @XmlElement(name = "value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Get map entry reference.
     * @return entry reference
     */
    @Override
    public String getRef() {
        return ref;
    }

    /**
     * Set map entry reference.
     * @param reference entry reference
     */
    @Override
    @XmlElement(name = "ref")
    public void setRef(String reference) {
        this.ref = reference;
    }

}
