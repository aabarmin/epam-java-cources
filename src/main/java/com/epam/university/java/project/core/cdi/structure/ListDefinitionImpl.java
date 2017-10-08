package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
import java.util.List;

/**
 * Created by Александр on 06.10.2017.
 * ListDefinition
 */
@XmlRootElement(name = "list")
public class ListDefinitionImpl implements ListDefinition{
    private Collection<ListItemDefinition> data;
    /**
     * Get list items.
     *
     * @return list items
     */
    @Override
    public Collection<ListItemDefinition> getItems() {
        return data;
    }

    /**
     * Set list items.
     *
     * @param items collection of list items
     */
    @XmlElement(name = "value", type = ListItemDefinitionImpl.class)
    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        data = items;
    }
}
