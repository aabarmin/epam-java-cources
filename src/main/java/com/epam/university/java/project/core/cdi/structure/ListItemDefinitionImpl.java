package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlValue;

/**
 * Implementation class for ListItemDefinition.
 *
 * @author Sergei Titov
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListItemDefinitionImpl implements ListDefinition.ListItemDefinition {

    @XmlValue
    private String value;

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
}