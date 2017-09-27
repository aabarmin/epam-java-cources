package com.epam.university.java.project.core.cdi.impl.bean;

import com.epam.university.java.project.core.cdi.bean.BeanPropertyDefinition;
import com.epam.university.java.project.core.cdi.impl.structure.DefaultListDefinition;
import com.epam.university.java.project.core.cdi.impl.structure.DefaultMapDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Default definition of bean's property.
 */
@XmlRootElement(name = "property")
public class DefaultBeanPropertyDefinition implements BeanPropertyDefinition {

    private String name;
    private String value;
    private String ref;
    private StructureDefinition data;

    /**
     * Get the property name.
     * @return name of property
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set the property name.
     * @param name name of property
     */
    @Override
    @XmlAttribute(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the property value.
     * @return value of property
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Set the property value.
     * @param value value of property
     */
    @Override
    @XmlAttribute(name = "value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Get reference by id to another bean.
     * @return referenced bean name
     */
    @Override
    public String getRef() {
        return ref;
    }

    /**
     * Set reference by id to another bean.
     * @param ref referenced bean name
     */
    @Override
    @XmlAttribute(name = "ref")
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * Get inner property data.
     * @return structure definition
     */
    @Override
    public StructureDefinition getData() {
        return data;
    }

    /**
     * Set inner property data.
     * @param data structure definition
     */
    @Override
    @XmlElements({
        @XmlElement(name = "list", type = DefaultListDefinition.class),
        @XmlElement(name = "map", type = DefaultMapDefinition.class)
    })
    public void setData(StructureDefinition data) {
        this.data = data;
    }

}
