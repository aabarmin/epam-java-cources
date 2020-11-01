package com.epam.university.java.project.core.cdi.structure;

import java.util.Collection;

public class MapDefinitionImpl implements MapDefinition {
    private Collection<MapEntryDefinition> values;

    @Override
    public Collection<MapEntryDefinition> getValues() {
        return values;
    }

    @Override
    public void setValues(Collection<MapEntryDefinition> values) {
        this.values = values;
    }

    public static class MapEntryDefinitionImpl implements MapEntryDefinition {
        private String mKey;
        private String mValue;
        private String mRef;

        @Override
        public String getKey() {
            return mKey;
        }

        @Override
        public void setKey(String key) {
            this.mKey = key;
        }

        @Override
        public String getValue() {
            return mValue;
        }

        @Override
        public void setValue(String value) {
            this.mValue = value;
        }

        @Override
        public String getRef() {
            return mRef;
        }

        @Override
        public void setRef(String reference) {
            this.mRef = reference;
        }
    }

}
