package com.epam.university.java.project.core.cdi.structure;

import com.epam.university.java.project.core.cdi.structure.ListDefinition.ListItemDefinition;
import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl.ListItemDefinitionImpl;
import java.util.ArrayList;
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
public class MapDefinitionImpl implements MapDefinition {

    @XmlElement(type = MapEntryDefinitionImpl.class)
    Collection<MapEntryDefinition> entries = new ArrayList<>();

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return entries;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.entries = values;
    }

    @XmlElementWrapper(name = "map")
    @XmlElement(type = ListItemDefinitionImpl.class)
    protected List<MapEntryDefinition> getXmlCollection() {
        return new CollectionAdapter<MapEntryDefinition>(entries);
    }

    @XmlRootElement(name = "entry")
    static class MapEntryDefinitionImpl implements MapEntryDefinition{

        private String key;
        private String value;
        private String ref;

        @Override
        public String getKey() {
            return key;
        }

        @Override
        public void setKey(String key) {
            this.key = key;
        }

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String getRef() {
            return ref;
        }

        @Override
        public void setRef(String reference) {
            this.ref = reference;
        }
    }
}
