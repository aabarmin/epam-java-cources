package com.epam.university.java.project.core.cdi.structure;

import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ilya on 24.09.17.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ListDefinitionImpl implements ListDefinition {

    Collection<ListItemDefinition> listItemDefinitions;

    @Override
    public Collection<ListItemDefinition> getItems() {
        return listItemDefinitions;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.listItemDefinitions = items;
    }

    @XmlElementWrapper()
    @XmlElement(name = "list", type = ListItemDefinitionImpl.class)
    protected List<ListItemDefinition> getXmlCollection() {
        return new CollectionAdapter<ListItemDefinition>(listItemDefinitions);
    }

    @XmlRootElement
    public static class ListItemDefinitionImpl implements ListItemDefinition{

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
