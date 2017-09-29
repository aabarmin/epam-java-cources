package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class MapDefinitionImpl implements MapDefinition {

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement
    class mapEntery implements MapDefinition.MapEntryDefinition {

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

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return null;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {

    }
}
