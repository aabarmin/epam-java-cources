package com.epam.university.java.project.core.cdi.impl.structure;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

/**
 * Default definition of list item.
 */
@XmlRootElement(name = "value")
public class DefaultListItemDefinition implements ListDefinition.ListItemDefinition {

    private String value;

    /**
     * Get list item value.
     * @return item value
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Set list item value.
     * @param value item value
     */
    @Override
    @XmlValue
    public void setValue(String value) {
        this.value = value;
    }

}
