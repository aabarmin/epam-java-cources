package com.epam.university.java.project.core.cdi.structure;

import java.util.Collection;
import java.util.HashMap;

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
}
