package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Romin Nuro on 24.09.2020 1:21.
 */
@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListDefinitionImpl implements ListDefinition {
    private Collection<ListItemDefinition> items = new ArrayList<>();

    /**
     * Get list items.
     *
     * @return list items
     */
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
    @XmlElement(name = "value", type = ListItemDefinitionImpl.class)
    public void setItems(Collection<ListItemDefinition> items) {
        this.items = items;
    }
    @XmlRootElement(name = "value")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class ListItemDefinitionImpl implements ListItemDefinition {
        private String value;

        /**
         * Get list item value.
         *
         * @return item value
         */
        @Override
        public String getValue() {
            return value;
        }

        /**
         * Set list item value.
         *
         * @param value item value
         */
        @Override
        @XmlValue
        public void setValue(String value) {
            this.value = value;
        }
    }
}
