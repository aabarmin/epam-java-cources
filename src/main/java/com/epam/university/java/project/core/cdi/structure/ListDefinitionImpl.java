package com.epam.university.java.project.core.cdi.structure;

import java.util.ArrayList;
import java.util.Collection;

public class ListDefinitionImpl implements ListDefinition {

    Collection<ListItemDefinition> items = new ArrayList<>();

    @Override
    public Collection<ListItemDefinition> getItems() {
        return items;
    }

    @Override
    public void setItems(Collection<ListItemDefinition> items) {
        this.items = items;
    }
}
