package com.epam.university.java.project.core.cdi.structure;

public class MapEntryDefinitionImpl implements MapDefinition.MapEntryDefinition {

    private String key;
    private String value;
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
