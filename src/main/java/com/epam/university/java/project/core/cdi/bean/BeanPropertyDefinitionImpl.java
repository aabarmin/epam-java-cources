package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.MapDefinitionImpl;
import com.epam.university.java.project.core.cdi.structure.StructureDefinition;


import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "property")
public class BeanPropertyDefinitionImpl implements BeanPropertyDefinition {
    @XmlAttribute(name = "name")
    private String propertyName;

    @XmlAttribute(name = "value")
    private String propertyValue;

    @XmlAttribute
    private String ref;

    @XmlElements({
            @XmlElement(type = ListDefinitionImpl.class, name = "list"),
            @XmlElement(type = MapDefinitionImpl.class, name = "map")
    }
    )
    private StructureDefinition data;

    @Override
    public String getName() {
        return propertyName;
    }

    @Override
    public void setName(String name) {
        this.propertyName = name;

    }

    @Override
    public String getValue() {
        return propertyValue;
    }

    @Override
    public void setValue(String value) {
        this.propertyValue = value;

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
