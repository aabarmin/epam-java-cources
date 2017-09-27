package com.epam.university.java.project.core.cdi.structure;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ilya on 24.09.17.
 */
@XmlRootElement
public class MapDefinitionImpl implements MapDefinition {

    @XmlAnyElement
    Collection<MapEntryDefinition> entries = new ArrayList<>();

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return entries;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.entries = values;
    }

    @XmlRootElement
    class MapEntryDefinitionImpl implements MapEntryDefinition{

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
