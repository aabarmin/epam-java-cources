package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Александр on 06.10.2017.
 * Implementation if map entry definition
 */
@XmlRootElement(name = "entry")
public class MapEntryDefinitionImpl implements MapDefinition.MapEntryDefinition {
    private String key;
    private String value;
    private String ref;


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
    @XmlElement(name = "key")
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
    @XmlElement(name = "value")
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
        return ref;
    }

    /**
     * Set map entry reference.
     *
     * @param reference entry reference
     */
    @XmlElement(name = "ref")
    @Override
    public void setRef(String reference) {
        this.ref = reference;
    }
}
