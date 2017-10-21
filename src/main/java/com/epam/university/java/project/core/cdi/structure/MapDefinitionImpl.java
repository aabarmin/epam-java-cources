package com.epam.university.java.project.core.cdi.structure;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by ilya on 24.09.17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MapDefinitionImpl implements MapDefinition {

    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
    Collection<MapEntryDefinition> entries = new ArrayList<>();

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return entries;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.entries = values;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    static class MapEntryDefinitionImpl implements MapEntryDefinition {

        @XmlElement
        private String key;
        @XmlElement
        private String value;
        @XmlElement
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
