package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class ListDefinitionImpl implements ListDefinition {
    @XmlElement(type = ListItemDefinitionImpl.class,
            name = "value")
    private List<ListItemDefinition> listElements = new ArrayList<>();

    @Override
    public Collection<ListItemDefinition> getItems() {
        return listElements;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        listElements.addAll(items);
    }
}
