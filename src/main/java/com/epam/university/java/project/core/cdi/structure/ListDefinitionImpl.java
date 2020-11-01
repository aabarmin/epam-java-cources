package com.epam.university.java.project.core.cdi.structure;

import java.util.Collection;

public class ListDefinitionImpl implements ListDefinition {
    private Collection<ListItemDefinition> mListItemDefinitions;

    @Override
    public Collection<ListItemDefinition> getItems() {
        return mListItemDefinitions;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.mListItemDefinitions = items;
    }

    public static class ListItemDefinitionImpl implements ListItemDefinition {
        private String mValue;

        @Override
        public String getValue() {
            return mValue;
        }

        @Override
        public void setValue(String value) {
            this.mValue = value;
        }
    }
}
