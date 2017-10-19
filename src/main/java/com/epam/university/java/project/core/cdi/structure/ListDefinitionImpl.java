package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Implementation class for ListDefinition.
 *
 * @author Sergei Titov
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListDefinitionImpl implements ListDefinition {

    @XmlElement(type = ListItemDefinitionImpl.class, name = "value")
    private Collection<ListItemDefinition> list = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
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