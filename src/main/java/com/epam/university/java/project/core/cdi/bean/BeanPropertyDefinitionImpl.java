package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

/**
 * Created by Romin Nuro on 24.09.2020 1:12.
 */
public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {
    private String name;
    private String value;
    private String ref;
    private StructureDefinition data;

    /**
     * Get the property name.
     *
     * @return name of property
     */
    @Override
    public String getName() {
        return null;
    }

    /**
     * Set the property name.
     *
     * @param name name of property
     */
    @Override
    @XmlAttribute(name = "name")
    public void setName(String name) {

    }

    /**
     * Get the property value.
     *
     * @return value of property
     */
    @Override
    public String getValue() {
        return null;
    }

    /**
     * Set the property value.
     *
     * @param value value of property
     */
    @Override
    @XmlAttribute(name = "value")
    public void setValue(String value) {

    }

    /**
     * Get reference by id to another bean.
     *
     * @return referenced bean name
     */
    @Override
    public String getRef() {
        return null;
    }

    /**
     * Set reference by id to another bean.
     *
     * @param ref referenced bean name
     */
    @Override
    @XmlAttribute(name = "ref")
    public void setRef(String ref) {

    }

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
    @XmlElements({
            @XmlElement(name = "list", type = ListDefinitionImpl.class)
    })
    public void setData(StructureDefinition data) {

    }
}
