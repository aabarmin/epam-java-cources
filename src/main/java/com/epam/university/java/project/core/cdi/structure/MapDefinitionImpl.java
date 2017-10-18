package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Class implements <code>MapDefinition</code>.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "map")
public class MapDefinitionImpl implements MapDefinition {
    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
    private Collection<MapEntryDefinition> entries = new ArrayList<>();

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return entries;
    }


    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.entries = values;
    }

    @XmlRootElement(name = "entry")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class MapEntryDefinitionImpl implements MapEntryDefinition {
        @XmlElement(name = "key")
        private String key;
        @XmlElement(name = "value")
        private String value;
        @XmlElement(name = "ref")
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