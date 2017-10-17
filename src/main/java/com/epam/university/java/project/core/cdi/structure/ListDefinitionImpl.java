package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "list")
public class ListDefinitionImpl implements ListDefinition {

    @XmlElement(name = "value", type = ListDefinitionImpl.class)
    private Collection<ListItemDefinition> items;

    @Override
    public Collection<ListItemDefinition> getItems() {
        return items;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.items = items;
    }
}
