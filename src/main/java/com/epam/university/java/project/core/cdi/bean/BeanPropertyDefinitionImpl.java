package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinitionImpl;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by Александр on 29.09.2017.
 * Bean property definition
 */
@XmlRootElement(name = "property")
public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {
    private String name;
    private String value;
    private String reference;
    private StructureDefinition structure;

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
    @XmlAttribute(name = "name")
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
    @XmlAttribute(name = "value")
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
        return reference;
    }

    /**
     * Set reference by id to another bean.
     *
     * @param ref referenced bean name
     */
    @XmlAttribute(name = "ref")
    @Override
    public void setRef(String ref) {
        this.reference = ref;
    }

    /**
     * Get inner property data.
     *
     * @return structure definition
     */
    @Override
    public StructureDefinition getData() {
        return structure;
    }

    /**
     * Set inner property data.
     *
     * @param data structure definition
     */
    @XmlElements({
            @XmlElement(name = "list", type = ListDefinitionImpl.class),
            @XmlElement(name = "map", type = MapDefinitionImpl.class)
    })
    @Override
    public void setData(StructureDefinition data) {
        this.structure = data;
    }
}
