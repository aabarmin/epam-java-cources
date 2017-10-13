package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "entry")
public class MapEntryDefinitionImpl implements MapDefinition.MapEntryDefinition {
    @XmlElement(name = "key")
    private String key;
    @XmlElement(name = "value")
    private String value;
    @XmlElement(name = "ref")
    private String reference;

    /**
     * Get map entry key.
     *
     * @return entry key
     */
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
