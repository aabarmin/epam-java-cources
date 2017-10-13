package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entry")
public class MapEntryDefinitionImpl implements MapDefinition.MapEntryDefinition {
    private String key;
    private String value;
    private String reference;

    /**
     * Get map entry key.
     *
     * @return entry key
     */
    @XmlElement(name = "key")
    @Override
    public String getKey() {
        return key;
    }

    /**
     * Set map entry key.
     *
     * @param key entry key
     */
    @Override
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Get map entry value.
     *
     * @return entry value
     */
    @XmlElement(name = "value")
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Set map entry value.
     *
     * @param value entry value
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Get map entry reference.
     *
     * @return entry reference
     */
    @XmlElement(name = "ref")
    @Override
    public String getRef() {
        return reference;
    }

    /**
     * Set map entry reference.
     *
     * @param reference entry reference
     */
    @Override
    public void setRef(String reference) {
        this.reference = reference;
    }
}
