package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

@XmlAccessorType(XmlAccessType.NONE)
public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {
    @XmlElement
    private String name;
    @XmlElement
    private String value;
    @XmlElement
    private String ref;
    @XmlElements({
            @XmlElement(name = "list", type = ListDefinitionImpl.class),
            @XmlElement(name = "map", type = MapDefinitionImpl.class)
    })
    private StructureDefinition data;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
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
