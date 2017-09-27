package com.epam.university.java.project.core.cdi.structure;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ilya on 24.09.17.
 */
@XmlRootElement
public class ListDefinitionImpl implements ListDefinition {

    @XmlAnyElement
    Collection<ListItemDefinition> listItemDefinitions;

    @Override
    public Collection<ListItemDefinition> getItems() {
        return listItemDefinitions;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.listItemDefinitions = items;
    }

    @XmlRootElement
    class ListItemDefinitionImpl implements ListItemDefinition{

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
