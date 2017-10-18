package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class MapEntryDefinitionImpl implements MapDefinition.MapEntryDefinition {
    @XmlElement
    String key;
    @XmlElement
    String value;
    @XmlElement
    String ref;

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public void setKey(String key) {
        this.key = key;

    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;

    }

    @Override
    public String getRef() {
        return ref;
    }

    @Override
    public void setRef(String reference) {
        this.ref = ref;

    }
}
