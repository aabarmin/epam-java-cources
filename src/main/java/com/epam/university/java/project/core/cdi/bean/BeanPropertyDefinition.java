package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

/**
 * Definition of bean's property.
 */
public interface BeanPropertyDefinition {
    /**
     * Get the property name.
     * @return name of property
     */
    String getName();

    /**
     * Set the property name.
     * @param name name of property
     */
    void setName(String name);

    /**
     * Get the property value.
     * @return value of property
     */
    String getValue();

    /**
     * Set the property value.
     * @param value value of property
     */
    void setValue(String value);

    /**
     * Get reference by id to another bean.
     * @return referenced bean name
     */
    String getRef();

    /**
     * Set reference by id to another bean.
     * @param ref referenced bean name
     */
    void setRef(String ref);

    /**
     * Get inner property data.
     * @return structure definition
     */
    StructureDefinition getData();

    /**
     * Set inner property data.
     * @param data structure definition
     */
    void setData(StructureDefinition data);
}
