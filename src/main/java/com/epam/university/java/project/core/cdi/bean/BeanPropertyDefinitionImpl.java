package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {
    private String name;
    private String value;
    private String ref;

    /**
     * Get the property name.
     *
     * @return name of property
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set the property name.
     *
     * @param name name of property
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the property value.
     *
     * @return value of property
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Set the property value.
     *
     * @param value value of property
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Get reference by id to another bean.
     *
     * @return referenced bean name
     */
    @Override
    public String getRef() {
        return ref;
    }

    /**
     * Set reference by id to another bean.
     *
     * @param ref referenced bean name
     */
    @Override
    public void setRef(String ref) {
        this.ref = ref;
    }

    //TODO: Implement methods!

    /**
     * Get inner property data.
     *
     * @return structure definition
     */
    @Override
    public StructureDefinition getData() {
        return null;
    }

    /**
     * Set inner property data.
     *
     * @param data structure definition
     */
    @Override
    public void setData(StructureDefinition data) {

    }
}
