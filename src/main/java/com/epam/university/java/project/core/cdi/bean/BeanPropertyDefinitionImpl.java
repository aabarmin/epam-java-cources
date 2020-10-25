package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {
    private String mName;
    private String mValue;
    private String mRef;
    private StructureDefinition mData;

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void setName(String name) {
        this.mName = name;
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
    public void setRef(String ref) {
        this.mRef = ref;
    }

    @Override
    public StructureDefinition getData() {
        return mData;
    }

    @Override
    public void setData(StructureDefinition data) {
        this.mData = data;
    }
}
