package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "map")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapDefinitionImpl implements MapDefinition {

    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
    private Collection<MapEntryDefinition> values = new ArrayList<>();

    @Override
    public String toString() {
        return "\n\tMapDefinitionImpl{"
                + "\n\tvalues=" + values + '}';
    }

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return values;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.values = values;
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
        public String toString() {
            return "\n\tMapEntryDefinitionImpl{"
                    + "\n\tkey='" + key + '\''
                    + ", \n\tvalue='" + value + '\''
                    + ", \n\tref='" + ref + '\'' + '}';
        }

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
        public void setRef(String ref) {
            this.ref = ref;
        }
    }
}
