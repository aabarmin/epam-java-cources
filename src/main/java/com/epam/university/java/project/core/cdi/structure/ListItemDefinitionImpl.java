package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "value")
public class ListItemDefinitionImpl implements ListDefinition.ListItemDefinition {
    @XmlValue
    private String value;

    /**
     * Get list item value.
     *
     * @return item value
     */
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
