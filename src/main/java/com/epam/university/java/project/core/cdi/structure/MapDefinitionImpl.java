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

    /**
     * Get map entry collection.
     *
     * @return entry collection
     */
    @Override
    public Collection<MapEntryDefinition> getValues() {
        return new ArrayList<>(values);
    }

    /**
     * Set map entry collection.
     *
     * @param values entry collection
     */
    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.values = new ArrayList<>(values);
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
            this.ref = ref;
        }
    }

}
