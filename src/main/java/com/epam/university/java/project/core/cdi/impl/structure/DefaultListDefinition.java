package com.epam.university.java.project.core.cdi.impl.structure;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Default definition of list.
 */
@XmlRootElement(name = "list")
public class DefaultListDefinition implements ListDefinition {

    private Collection<ListItemDefinition> items;

    /**
     * Get list items.
     * @return list items
     */
    @Override
    public Collection<ListItemDefinition> getItems() {
        return items;
    }

    /**
     * Set list items.
     * @param items collection of list items
     */
    @Override
    @XmlElement(name = "value", type = DefaultListItemDefinition.class)
    public void setItems(Collection<ListItemDefinition> items) {
        this.items = items;
    }

}
