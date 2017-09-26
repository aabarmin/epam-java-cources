package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class ListDefinitionImpl implements ListDefinition {

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement
    class ListElement implements ListDefinition.ListItemDefinition {
        @XmlElement
        private String value;

        @Override
        public String getValue() {
            return null;
        }

        @Override
        public void setValue(String value) {

        }
    }

    @Override
    public Collection<ListItemDefinition> getItems() {
        return null;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {

    }
}
