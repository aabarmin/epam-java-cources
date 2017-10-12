package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

public class BeanPropertyDefinitionImpl implements  BeanPropertyDefinition {
    private String propertyName;
    private String propertuValue;
    private String ref;
    private StructureDefinition data;
    @Override
    public String getName() {
        return propertyName;
    }

    @Override
    public void setName(String name) {
        this.propertyName = name;

    }

    @Override
    public String getValue() {
        return propertuValue;
    }

    @Override
    public void setValue(String value) {
        this.propertuValue=value;

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
