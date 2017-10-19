package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Implementation class for ListDefinition.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.NONE)
public class ListDefinitionImpl implements ListDefinition {

    private Collection<ListItemDefinition> list = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    @XmlElement(name = "value")
    public Collection<ListItemDefinition> getItems() {
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.list = items;
    }
}

/**
 * Implementation class for ListItemDefinition.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "value")
@XmlAccessorType(XmlAccessType.FIELD)
class ListItemDefinitionImpl implements ListDefinition.ListItemDefinition {

    private String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}