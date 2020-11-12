package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {
    private String name;
    private String value;
    private String ref;
    private StructureDefinition data;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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

    @Override
    public StructureDefinition getData() {
        return data;
    }

    @Override
    public void setData(StructureDefinition data) {
        this.data = data;
    }
}
