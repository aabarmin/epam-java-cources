package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "list")
public class ListDefinitionImpl extends StructureDefinitionImpl implements ListDefinition {

    @XmlElement(type = ListItemDefinitionImpl.class, name = "value")
    private List<ListItemDefinition> items = new ArrayList<>();

    @Override
    public Collection<ListItemDefinition> getItems() {
        return this.items;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.items.addAll(items);

    }
}
