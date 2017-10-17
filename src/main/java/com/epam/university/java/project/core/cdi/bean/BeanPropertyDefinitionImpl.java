package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.StructureDefinition;
import com.epam.university.java.project.core.cdi.structure.StructureDefinitionImpl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Implementation class for BeanPropertyDefinition.
 *
 * @author Sergei Titov
 */
@XmlRootElement(name = "property")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {

    private String name;

    private String value;

    private String ref;

    @XmlElements({
            @XmlElement(type = StructureDefinitionImpl.class)
    })
    StructureDefinition data;

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getRef() {
        return ref;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public StructureDefinition getData() {
        return data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setData(StructureDefinition data) {
        //this.data = data;
    }
}
