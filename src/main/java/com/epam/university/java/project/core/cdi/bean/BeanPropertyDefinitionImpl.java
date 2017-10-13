package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "property")
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
    @XmlAttribute(name = "name")
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
    @XmlAttribute(name = "value")
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
    @XmlAttribute(name = "ref")
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

    /**
     * Get inner property data.
     *
     * @return structure definition
     */

    @Override
    @XmlElements({
            @XmlElement(name = "list", type = ListDefinitionImpl.class),
            @XmlElement(name = "map", type = MapDefinitionImpl.class)
    })
    public StructureDefinition getData() {
        return data;
    }

    /**
     * Set inner property data.
     *
     * @param data structure definition
     */
    @Override
    public void setData(StructureDefinition data) {
        this.data = data;
    }
}
