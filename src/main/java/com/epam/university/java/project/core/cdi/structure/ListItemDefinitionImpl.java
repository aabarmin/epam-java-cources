package com.epam.university.java.project.core.cdi.structure;

public class ListItemDefinitionImpl implements ListDefinition.ListItemDefinition {

    private String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
