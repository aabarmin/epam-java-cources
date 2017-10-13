package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "list")
public class ListDefinitionImpl implements ListDefinition {
    private Collection<ListItemDefinition> items;
    
    /**
     * Get list items.
     *
     * @return list items
     */
    @XmlElement(name = "value", type = ListItemDefinitionImpl.class)
    @Override
    public Collection<ListItemDefinition> getItems() {
        return items;
    }

    /**
     * Set list items.
     *
     * @param items collection of list items
     */
    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.items = items;
    }
}
