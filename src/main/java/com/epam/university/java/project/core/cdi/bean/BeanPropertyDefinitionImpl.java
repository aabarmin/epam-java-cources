package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

/**
 * Created by ilya on 24.09.17.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {

    private String name;
    private String value;
    private String ref;

    private StructureDefinition structureDefinition;

    @Override
    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getValue() {
        return value;
    }


    @XmlAttribute(name = "value")
    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String getRef() {
        return ref;
    }


    @XmlAttribute(name = "ref")
    @Override
    public void setRef(String ref) {
        this.ref = ref;
    }


    @XmlElements({
        @XmlElement(name = "list", type = ListDefinitionImpl.class),
        @XmlElement(name = "map", type = MapDefinitionImpl.class)
    })
    @Override
    public StructureDefinition getData() {
        return structureDefinition;
    }

    @Override
    public void setData(StructureDefinition data) {
        this.structureDefinition = data;
    }
}
