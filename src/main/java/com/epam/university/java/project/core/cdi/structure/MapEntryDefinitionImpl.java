package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Implementation class for MapEntryDefinition.
 *
 * @author Sergei Titov
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MapEntryDefinitionImpl implements MapDefinition.MapEntryDefinition {

    @XmlElement
    private String key;

    @XmlElement
    private String value;

    @XmlElement
    private String ref;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getKey() {
        return key;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRef() {
        return ref;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRef(String reference) {
        this.ref = ref;
    }

    public String getBody() {
        return (null == ref) ? value : ref;
    }
}


