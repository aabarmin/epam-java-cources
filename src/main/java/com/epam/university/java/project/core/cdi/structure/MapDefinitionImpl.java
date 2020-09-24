package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by Romin Nuro on 24.09.2020 14:16.
 */
@XmlRootElement(name = "map")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapDefinitionImpl implements MapDefinition {
    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
    private Collection<MapEntryDefinition> values;

    @Override
    public String toString() {
        return "MapDefinitionImpl{" +
                "values=" + values +
                '}';
    }

    /**
     * Get map entry collection.
     *
     * @return entry collection
     */
    @Override
    public Collection<MapEntryDefinition> getValues() {
        return null;
    }

    /**
     * Set map entry collection.
     *
     * @param values entry collection
     */
    @Override
    public void setValues(Collection<MapEntryDefinition> values) {

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
            return "MapEntryDefinitionImpl{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    ", ref='" + ref + '\'' +
                    '}';
        }

        /**
         * Get map entry key.
         *
         * @return entry key
         */
        @Override
        public String getKey() {
            return key;
        }

        /**
         * Set map entry key.
         *
         * @param key entry key
         */
        @Override
        public void setKey(String key) {
            this.key = key;
        }

        /**
         * Get map entry value.
         *
         * @return entry value
         */
        @Override
        public String getValue() {
            return value;
        }

        /**
         * Set map entry value.
         *
         * @param value entry value
         */
        @Override
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Get map entry reference.
         *
         * @return entry reference
         */
        @Override
        public String getRef() {
            return ref;
        }

        /**
         * Set map entry reference.
         *
         * @param reference entry reference
         */
        @Override
        public void setRef(String reference) {
            this.ref = reference;
        }
    }
}
