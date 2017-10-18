package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Class implements <code>ListDefinition</code> interface.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "list")
public class ListDefinitionImpl implements ListDefinition {
    @XmlElement(name = "value", type = ListItemDefinitionImpl.class)
    private Collection<ListItemDefinition> itemDefinitions;

    @Override
    public Collection<ListItemDefinition> getItems() {
        return itemDefinitions;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.itemDefinitions = items;
    }

    @XmlRootElement(name = "value")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ListItemDefinitionImpl implements ListItemDefinition {
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
