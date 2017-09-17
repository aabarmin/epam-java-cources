package com.epam.university.java.project.core.cdi.structure;

import java.util.Collection;

/**
 * Definition of map.
 */
public interface MapDefinition extends StructureDefinition {
    /**
     * Get map entry collection.
     * @return entry collection
     */
    Collection<MapEntryDefinition> getValues();

    /**
     * Set map entry collection.
     * @param values entry collection
     */
    void setValues(Collection<MapEntryDefinition> values);

    interface MapEntryDefinition {
        /**
         * Get map entry key.
         * @return entry key
         */
        String getKey();

        /**
         * Set map entry key.
         * @param key entry key
         */
        void setKey(String key);

        /**
         * Get map entry value.
         * @return entry value
         */
        String getValue();

        /**
         * Set map entry value.
         * @param value entry value
         */
        void setValue(String value);

        /**
         * Get map entry reference.
         * @return entry reference
         */
        String getRef();

        /**
         * Set map entry reference.
         * @param reference entry reference
         */
        void setRef(String reference);
    }
}
