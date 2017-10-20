package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.Collection;

public class ListDefinitionImpl implements ListDefinition {
    private Collection<ListItemDefinition> listItemDefinitions;

    @XmlElement(name = "value", type = ListDefinitionImpl.class)
    @Override
    public Collection<ListItemDefinition> getItems() {
        return listItemDefinitions;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.listItemDefinitions = items;
    }
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ListItemDefinitionImpl implements ListItemDefinition {
        @XmlValue
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
}
