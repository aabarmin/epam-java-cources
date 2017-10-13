package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "value")
public class ListItemDefinitionImpl implements ListDefinition.ListItemDefinition {
    private String value;

    /**
     * Get list item value.
     *
     * @return item value
     */
    @XmlValue
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Set list item value.
     *
     * @param value item value
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
