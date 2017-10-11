package com.epam.university.java.project.core.cdi.structure;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl.ListItemDefinitionImpl;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by ilya on 24.09.17.
 */


@XmlAccessorType(XmlAccessType.FIELD)
public class ListDefinitionImpl implements ListDefinition {

    @XmlElement(type = ListItemDefinitionImpl.class, name = "value")
    Collection<ListItemDefinition> listItemDefinitions;

    @Override
    public Collection<ListItemDefinition> getItems() {
        return listItemDefinitions;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.listItemDefinitions = items;
    }

    public static class ListItemDefinitionImpl implements ListItemDefinition{
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
